package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CargoIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 * IntakeRollersIntake is a command
 * that makes the cargo intake rollers
 * spin inwards to intake the cargo
 */

public class IntakeRollersIntake extends CargoIORollersSet {
	public IntakeRollersIntake(Motor... motors) {
		super(CargoIO.INTAKE_SPEED);
		for (Motor motor : motors) {
			requires(motor);
		}
	}
}