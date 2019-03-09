package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ManipulatorClawsDown extends SolenoidRetract {
	public ManipulatorClawsDown() {
		super("ManipulatorClawsDown", RobotMap.Component.manipulator.claws);
	}
}