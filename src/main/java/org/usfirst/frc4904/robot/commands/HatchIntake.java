package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HatchIntake extends MotorConstant {
	public HatchIntake() {
		super("HatchIntake", RobotMap.Component.floorio.hatchRoller, FloorIO.HATCH_INTAKE_SPEED);
	}
}