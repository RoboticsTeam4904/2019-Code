package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class HatchGrabberIn extends SolenoidRetract {
	public HatchGrabberIn() {
		super("HatchGrabberIn", RobotMap.Component.manipulator.hatchGrabber);
	}
}