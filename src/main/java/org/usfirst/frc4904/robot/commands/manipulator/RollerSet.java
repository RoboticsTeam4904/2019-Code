package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class RollerSet extends MotorConstant {
	public RollerSet(String name, double speed) {
		super(name, RobotMap.Component.manipulator.roller, speed);
	}
}