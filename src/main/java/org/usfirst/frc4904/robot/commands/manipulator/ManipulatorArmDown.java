package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ManipulatorArmDown extends SolenoidRetract {
	public ManipulatorArmDown() {
		super("ManipulatorArmDown", RobotMap.Component.manipulator.arm);
	}
}