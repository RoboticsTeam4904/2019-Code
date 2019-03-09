package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

public class ManipulatorClawsDown extends RunIfElse {
	public ManipulatorClawsDown() {
		super(
			new SolenoidExtend("ManipulatorClawsDown", RobotMap.Component.manipulator.claws),
			new KittenCommand("Cannot flip claws down due to extension of the ground piston.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.hatchExtender.getState() == SolenoidState.RETRACT
		);
	}
}