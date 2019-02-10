package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.subsystems.FloorIO;

public class CargoIntake extends CommandGroup {
    public CargoIntake () {
		super("CargoIntake");
		addParallel(new MotorConstant(RobotMap.Component.cargoRollerIntake, FloorIO.CARGO_INTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.hatcherRollerIntake, FloorIO.HATCH_INTAKE_SPEED));
    }
}