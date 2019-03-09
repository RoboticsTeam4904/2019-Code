package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ManipulatorGroundOut extends SolenoidExtend {
	public ManipulatorGroundOut() {
		super("ManipulatorGroundOut", RobotMap.Component.manipulator.groundPiston);
	}
}