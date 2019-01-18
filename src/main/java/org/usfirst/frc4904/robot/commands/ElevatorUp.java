package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 put elevator in up position
 */
public class ElevatorUp extends MotorPositionConstant {
    public ElevatorUp() {
		super(RobotMap.Component.elevator, Elevator.ElevState.UP.position);
		
	}

    
}