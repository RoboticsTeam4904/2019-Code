package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;

/**
 * Flip manipulator Up.
 */
public class WristUp extends SolenoidRelease {
	public WristUp() {
		super("WristUp", RobotMap.Component.floorio.wrist);
	}
}