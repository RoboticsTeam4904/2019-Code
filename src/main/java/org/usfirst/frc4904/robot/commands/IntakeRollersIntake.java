package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.CargoIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeRollersIntake extends CommandGroup {
	public IntakeRollersIntake() {
		super("IntakeRollersIntake");
		addParallel(new MotorConstant(RobotMap.Component.cargoIO.rollerLeft, CargoIO.INTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.cargoIO.rollerRight, CargoIO.INTAKE_SPEED));
	}
}