package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class HatchExtenderIn extends SolenoidRetract {
	public HatchExtenderIn() {
		super("ManipulatorGroundIn", RobotMap.Component.manipulator.hatchExtender);
	}
}