package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Put elevator in up position
 */
public class ElevatorUp extends ElevatorSet {
	public ElevatorUp() {
		super(Elevator.ElevState.UP.position);
	}
}