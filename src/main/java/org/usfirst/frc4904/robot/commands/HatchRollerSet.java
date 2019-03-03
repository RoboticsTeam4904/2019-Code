package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HatchRollerSet extends MotorConstant {
	public HatchRollerSet(String name, double speed) {
		super(name, RobotMap.Component.floorio.hatchRoller, speed);
	}
}