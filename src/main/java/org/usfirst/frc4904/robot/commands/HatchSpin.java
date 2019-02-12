package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HatchSpin extends MotorConstant {
	public HatchSpin(String name, double speed) {
		super(name, RobotMap.Component.floorio.hatcherRollerIntake, speed);
	}
}
