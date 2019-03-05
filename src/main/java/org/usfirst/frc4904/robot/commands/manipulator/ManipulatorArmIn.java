package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ManipulatorArmIn extends SolenoidRetract {
	public ManipulatorArmIn() {
		super("ManipulatorArmIn", RobotMap.Component.manipulator.arm);
	}
}