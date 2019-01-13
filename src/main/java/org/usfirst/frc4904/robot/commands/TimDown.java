package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.robot.subsystems.Tim;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimDown extends MotorPositionConstant {
    public TimDown() {
		super(RobotMap.Component.tim.rotateMotor, Tim.TimState.FULL_DOWN.position);
		
	}

    
}