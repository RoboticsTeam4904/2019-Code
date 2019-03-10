package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class RollerOut extends RunFor {
	public RollerOut() {
		super(new MotorConstant("Roller Out", RobotMap.Component.manipulator.roller, Manipulator.OUTTAKE_SPEED), Manipulator.OUTTAKE_TIME);
	}
}