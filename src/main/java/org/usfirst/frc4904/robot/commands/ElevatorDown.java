
package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 puts elevator at down position
 */
public class ElevatorDown extends MotorPositionConstant {
    public ElevatorDown() {
		super(RobotMap.Component.elevator, Elevator.ElevState.DOWN.position);
		
	}

    
}