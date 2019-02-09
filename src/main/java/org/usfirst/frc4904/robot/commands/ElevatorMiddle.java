package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Elevator;

/**
 * Puts elevator at middle position
 */
public class ElevatorMiddle extends ElevatorSet {
	public ElevatorMiddle() {
		super(Elevator.ElevatorState.MIDDLE.position);
	}
}