package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClawsDown extends RunIfElse {
	public ClawsDown() {
		super(
			new SolenoidExtend("Claws Down", RobotMap.Component.manipulator.claws),
			new KittenCommand("Cannot flip claws down due to extension of the hatch extender piston.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.hatchExtender.getState() != SolenoidState.EXTEND
		);
	}

	public static class ClawsDownAndHatchExtenderIn extends CommandGroup {
		public ClawsDownAndHatchExtenderIn() {
			addParallel(new SolenoidExtend("Claws Down", RobotMap.Component.manipulator.claws));
			addParallel(new SolenoidRetract("HatchExtenderIn", RobotMap.Component.manipulator.hatchExtender));
		}
	}
}