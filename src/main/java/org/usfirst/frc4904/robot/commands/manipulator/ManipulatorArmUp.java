package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ManipulatorArmUp extends SolenoidExtend {
	public ManipulatorArmUp() {
		super("ManipulatorArmUp", RobotMap.Component.manipulator.arm);
	}
}