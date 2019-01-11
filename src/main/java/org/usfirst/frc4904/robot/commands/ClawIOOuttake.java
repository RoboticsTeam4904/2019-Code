package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.RobotMap.Component;
import org.usfirst.frc4904.robot.subsystems.ClawIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClawIOOuttake extends CommandGroup {
	public ClawIOOuttake() {
		// Use requires() here to declare subsystem dependencies
		requires(RobotMap.Component.clawIOLeft);
		requires(RobotMap.Component.clawIORight);
		addParallel(new MotorConstant(Component.clawIOLeft, ClawIO.OUTTAKE_SPEED));
		addParallel(new MotorConstant(Component.clawIORight, ClawIO.OUTTAKE_SPEED));
	}
}