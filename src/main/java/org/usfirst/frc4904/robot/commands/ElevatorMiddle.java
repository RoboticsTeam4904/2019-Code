package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Puts elevator at middle position
 */
public class ElevatorMiddle extends ElevatorSet {
	public ElevatorMiddle() {
		super(Elevator.ElevState.MIDDLE.position);
	}
}