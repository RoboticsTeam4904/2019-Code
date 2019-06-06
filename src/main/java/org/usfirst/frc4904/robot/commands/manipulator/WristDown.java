package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class WristDown extends SolenoidExtend {
	public WristDown() {
		super("Wrist Down", RobotMap.Component.manipulator.wrist);
	}
}