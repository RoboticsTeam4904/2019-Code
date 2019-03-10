package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class RollerSet extends RunFor {
	public RollerSet(double speed, double time) {
		super(new MotorConstant("Roller Set", RobotMap.Component.manipulator.roller, speed), time);
	}
}