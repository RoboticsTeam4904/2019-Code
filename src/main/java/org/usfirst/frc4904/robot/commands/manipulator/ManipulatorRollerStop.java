package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ManipulatorRollerStop extends RunFor {
	public ManipulatorRollerStop() {
		super(new MotorConstant("ManipulatorRollerStop", RobotMap.Component.manipulator.roller, Manipulator.STOP_SPEED), Manipulator.STOP_TIME);
	}
}