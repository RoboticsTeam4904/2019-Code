package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.subsystems.FloorIO;

public class CargoIntake extends CommandGroup {
	public CargoIntake() {
		super("CargoIntake");
		addParallel(new MotorConstant(RobotMap.Component.floorio.cargoRollerIntake, FloorIO.CARGO_INTAKE_SPEED_TOP));
		addParallel(new MotorConstant(RobotMap.Component.floorio.hatcherRollerIntake, FloorIO.CARGO_INTAKE_SPEED_BOTTOM));
	}
}