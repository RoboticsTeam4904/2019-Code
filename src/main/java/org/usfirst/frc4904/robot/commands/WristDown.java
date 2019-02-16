package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;

/**
 * Flip manipulator down
 */
public class WristDown extends SolenoidExtend {
	public WristDown() {
		super("FlipperDown", RobotMap.Component.floorio.wrist);
	}
}