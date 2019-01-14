package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.robot.subsystems.Tim;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimIntake extends MotorConstant {
    // should be called in parallel, one with tim.intakeMotor, one with tim.indexMotor
    public TimIntake(Motor motor) {
		  super(motor, Tim.TIM_INTAKE_SPEED);
  }
}

	