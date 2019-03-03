package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ManipulatorGrabberIn extends SolenoidRetract {
	public ManipulatorGrabberIn() {
		super("ManipulatorGrabberIn", RobotMap.Component.manipulator.grabber);
	}
}