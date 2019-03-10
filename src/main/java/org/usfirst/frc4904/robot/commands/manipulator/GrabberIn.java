package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class GrabberIn extends SolenoidRetract {
	public GrabberIn() {
		super("Grabber In", RobotMap.Component.manipulator.grabber);
	}
}