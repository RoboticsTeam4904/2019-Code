package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ManipulatorClawsIn extends SolenoidRetract {
	public ManipulatorClawsIn() {
		super("ManipulatorClawsIn", RobotMap.Component.manipulator.claws);
	}
}