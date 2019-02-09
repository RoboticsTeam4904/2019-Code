package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Elevator;

/**
 * Puts elevator at down position
 */
public class ElevatorDown extends ElevatorSet {
	public ElevatorDown() {
		super(Elevator.ElevatorState.DOWN.position);
	}
}