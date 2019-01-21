package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;

/**
 control elevator manually
 */
public class ElevatorSetRelative extends MotorPositionConstant {
    double newposition = RobotMap.Component.elevator.state.position + 5; //this '5' is a placeholder for driver input
	public ElevatorSetRelative(double newposition) {
		super(RobotMap.Component.elevator, newposition);
	}


}
