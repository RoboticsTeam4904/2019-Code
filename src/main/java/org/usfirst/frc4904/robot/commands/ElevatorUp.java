package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ElevatorUp extends RunFor {
	public ElevatorUp() {
		super(new MotorConstant("ElevatorUp", RobotMap.Component.fourBar.elevator, FourBarElevator.UP_SPEED),FourBarElevator.UP_TIME);
	}
}