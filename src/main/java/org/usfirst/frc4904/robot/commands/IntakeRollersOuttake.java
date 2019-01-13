package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CargoIO;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;


/**
 * IntakeRollersIntake is a command
 * that makes the cargo intake rollers
 * spin outwards to outtake the cargo
 */

public class IntakeRollersOuttake extends CargoIORollersSet {
	public IntakeRollersOuttake(Motor... motors) {
		super(CargoIO.OUTTAKE_SPEED);
		for (Motor motor : motors) {
			requires(motor);
		}
	}
}