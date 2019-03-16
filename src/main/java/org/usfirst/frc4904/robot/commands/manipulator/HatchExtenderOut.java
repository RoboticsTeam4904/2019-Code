package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.NetworkKittenError;

public class HatchExtenderOut extends RunIfElse {
	public HatchExtenderOut() {
		super(
			new HatchExtenderOutAndRaiseClaws(),
			new NetworkKittenError("Cannot extend hatch extender piston due to claws being down."),
			() -> RobotMap.Component.manipulator.claws.getState() != SolenoidState.EXTEND
		);
	}

	public static class HatchExtenderOutAndRaiseClaws extends CommandGroup {
		public HatchExtenderOutAndRaiseClaws() {
			addParallel(new ClawsUp());
			addParallel(new SolenoidExtend("HatchExtenderOut", RobotMap.Component.manipulator.hatchExtender));
		}
	}
}