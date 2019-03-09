package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ManipulatorGroundIn extends SolenoidRetract {
	public ManipulatorGroundIn() {
		super("ManipulatorGroundIn", RobotMap.Component.manipulator.groundPiston);
	}
}