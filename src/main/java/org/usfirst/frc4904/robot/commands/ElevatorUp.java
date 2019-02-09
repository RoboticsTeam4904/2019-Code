package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Elevator;

/**
 * Put elevator in up position
 */
public class ElevatorUp extends ElevatorSet {
	public ElevatorUp() {
		super(Elevator.ElevatorState.UP.position);
	}
}