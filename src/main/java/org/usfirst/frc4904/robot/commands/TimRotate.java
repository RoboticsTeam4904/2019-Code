package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;



public class TimRotate extends MotorPositionConstant {
	public TimRotate(double position) {
		super(RobotMap.Component.tim.rotateMotor, position);
	}


}