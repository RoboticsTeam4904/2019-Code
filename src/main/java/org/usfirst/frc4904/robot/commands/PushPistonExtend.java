package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;

/**
 * This command sets the state of the associated group to extended.
 */
public class PushPistonExtend extends SolenoidExtend {
	public PushPistonExtend() {
		super("PushPistonExtend", RobotMap.Component.pushPiston);
	}
}