package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.robot.subsystems.Tim;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimUp extends MotorPositionConstant {
    public TimUp() {
		super(RobotMap.Component.tim.rotateMotor, Tim.TimState.FULL_UP.position);
		
	}

    
}