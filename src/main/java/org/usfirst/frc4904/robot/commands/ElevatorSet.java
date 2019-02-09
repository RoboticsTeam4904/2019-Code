package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;

/**
 * Control elevator manually
 */
public class ElevatorSet extends MotorPositionConstant {
	public ElevatorSet(double position) {
		super(RobotMap.Component.elevator, position);
	}
}
