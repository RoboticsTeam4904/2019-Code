package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.subsystems.FloorIO;

public class CargoOuttake extends CommandGroup {
    public CargoOuttake () {
		super("CargoOuttake");
		addParallel(new MotorConstant(RobotMap.Component.cargoRollerIntake, FloorIO.CARGO_OUTTAKE_SPEED));
		addParallel(new MotorConstant(RobotMap.Component.hatcherRollerIntake, FloorIO.HATCH_OUTTAKE_SPEED));
    }
}