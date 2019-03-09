package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ManipulatorClawsUp extends SolenoidExtend {
	public ManipulatorClawsUp() {
		super("ManipulatorClawsUp", RobotMap.Component.manipulator.claws);
	}
}