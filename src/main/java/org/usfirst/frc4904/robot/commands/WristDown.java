package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

/**
 * Flip manipulator down
 */
public class WristDown extends SolenoidExtend {
	public WristDown() {
		super("WristDown", RobotMap.Component.floorio.wrist);
	}
}