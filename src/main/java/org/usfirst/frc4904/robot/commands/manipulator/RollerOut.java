package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class RollerOut extends MotorConstant {
	public RollerOut() {
		super("Roller Out", RobotMap.Component.manipulator.roller, Manipulator.OUTTAKE_SPEED);
	}
}