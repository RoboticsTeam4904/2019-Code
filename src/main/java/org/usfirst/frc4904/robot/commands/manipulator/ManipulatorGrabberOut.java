package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ManipulatorGrabberOut extends SolenoidExtend {
	public ManipulatorGrabberOut() {
		super("ManipulatorGrabberOut", RobotMap.Component.manipulator.grabber);
	}
}