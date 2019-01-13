package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 * Controls the intake rollers speed,
 * parents the IntakeRollersIntake
 * and IntakeRollersOuttake commands
 */

public class CargoIORollersSet extends CommandGroup {

	public CargoIORollersSet(double speed) {
		addParallel(
			new MotorConstant(RobotMap.Component.cargoIORollerRight, speed));
		addParallel(
			new MotorConstant(RobotMap.Component.cargoIORollerLeft, speed));
	}
}
