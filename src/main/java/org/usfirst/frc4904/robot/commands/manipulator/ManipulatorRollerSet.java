package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ManipulatorRollerSet extends RunFor {
	public ManipulatorRollerSet(double speed, double time) {
		super(new MotorConstant("ManipulatorRollerSet", RobotMap.Component.manipulator.roller, speed), time);
	}
}