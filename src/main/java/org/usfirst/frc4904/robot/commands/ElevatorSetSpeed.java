package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;

/**
 control elevator manually
 */
public class ElevatorSetSpeed extends Command {
	public ElevatorSetSpeed(double speed) {
		RobotMap.Component.elevator.set(speed);
	}
	@Override
	protected boolean isFinished() {
		return false;
	}

}
