package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ManipulatorRollerIn extends RunFor {
	public ManipulatorRollerIn() {
		super(new MotorConstant("ManipulatorRollerIn", RobotMap.Component.manipulator.roller, Manipulator.INTAKE_SPEED), Manipulator.INTAKE_TIME);
	}
}