package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ManipulatorArmOut extends SolenoidExtend {
	public ManipulatorArmOut() {
		super("ManipulatorArmOut", RobotMap.Component.manipulator.arm);
	}
}