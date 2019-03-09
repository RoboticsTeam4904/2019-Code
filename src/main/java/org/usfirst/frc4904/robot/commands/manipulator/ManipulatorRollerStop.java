package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;

public class ManipulatorRollerStop extends MotorIdle {
	public ManipulatorRollerStop() {
		super(RobotMap.Component.manipulator.roller);
	}
}