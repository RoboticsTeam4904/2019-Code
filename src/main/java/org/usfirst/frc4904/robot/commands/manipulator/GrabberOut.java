package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class GrabberOut extends SolenoidExtend {
	public GrabberOut() {
		super("Grabber Out", RobotMap.Component.manipulator.grabber);
	}
}