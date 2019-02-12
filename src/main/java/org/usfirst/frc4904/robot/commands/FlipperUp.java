package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;

/**
 * This command sets the state of the associated group to released.
 */
public class FlipperUp extends SolenoidRelease {
	public FlipperUp() {
		super("FlipperUp", RobotMap.Component.flipper);
	}
}