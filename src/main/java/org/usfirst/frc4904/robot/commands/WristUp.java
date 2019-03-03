package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

/**
 * Flip manipulator Up.
 */
public class WristUp extends SolenoidRetract {
	public WristUp() {
		super("WristUp", RobotMap.Component.floorio.wrist);
	}
}