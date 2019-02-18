package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HatchRollerIntake extends MotorConstant {
	public HatchRollerIntake() {
		super("HatchRollerIntake", RobotMap.Component.floorio.hatchRoller, FloorIO.HATCH_INTAKE_SPEED);
	}
}