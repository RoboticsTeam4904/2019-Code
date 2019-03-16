package org.usfirst.frc4904.robot.commands.manipulator;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.LogKitten;

public class RollerSet extends RunIfElse {
	public RollerSet(String name, double speed) {
		super(
			new RollerSetAndLowerClaws(name, speed),
			new KittenCommand("Cannot flip spin rollers due to claws being up.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.claws.getState() != SolenoidState.RETRACT
				|| RobotMap.Component.manipulator.isOverridden()
		);
	}

	public static class RollerSetAndLowerClaws extends CommandGroup {
		public RollerSetAndLowerClaws(String name, double speed) {
			addParallel(new ClawsDown());
			addParallel(new MotorConstant(name, RobotMap.Component.manipulator.roller, speed));
		}
	}
}