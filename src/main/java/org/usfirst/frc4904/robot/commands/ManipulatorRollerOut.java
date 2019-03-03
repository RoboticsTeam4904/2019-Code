package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ManipulatorRollerOut extends RunFor {
	public ManipulatorRollerOut() {
		super(new MotorConstant("ManipulatorRollerOut", RobotMap.Component.manipulator.roller, Manipulator.OUTTAKE_SPEED), Manipulator.OUTTAKE_TIME);
	}
}