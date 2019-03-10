package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class RollerIn extends MotorConstant {
	public RollerIn() {
		super("Roller In", RobotMap.Component.manipulator.roller, Manipulator.INTAKE_SPEED);
	}
}