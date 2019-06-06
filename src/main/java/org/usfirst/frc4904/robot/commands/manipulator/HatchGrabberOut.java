package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class HatchGrabberOut extends SolenoidExtend {
	public HatchGrabberOut() {
		super("HatchGrabberOut", RobotMap.Component.manipulator.hatchGrabber);
	}
}