package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class WristUp extends SolenoidRetract {
	public WristUp() {
		super("Wrist Up", RobotMap.Component.manipulator.wrist);
	}
}