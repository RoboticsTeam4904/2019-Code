package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;

public class RollerStop extends MotorIdle {
	public RollerStop() {
		super(RobotMap.Component.manipulator.roller);
	}
}