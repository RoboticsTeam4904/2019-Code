package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ElevatorDown extends RunFor {
	public ElevatorDown() {
		super(new MotorConstant("ElevatorDown", RobotMap.Component.fourBar.elevator, FourBarElevator.DOWN_SPEED),FourBarElevator.DOWN_TIME);
	}
}