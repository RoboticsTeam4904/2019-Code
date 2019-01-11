package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CargoIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 * IntakeRollersIntake is a command
 * that makes the cargo intake rollers
 * spin outwards to outtake the cargo
 */

public class IntakeRollersOuttake extends CommandGroup {
	public IntakeRollersOuttake() {
		super("IntakeRollersOuttake");
		addParallel(new MotorConstant(RobotMap.Component.cargoIO.rollerLeft, CargoIO.OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.cargoIO.rollerRight, CargoIO.OUTTAKE_SPEED));
	}
}