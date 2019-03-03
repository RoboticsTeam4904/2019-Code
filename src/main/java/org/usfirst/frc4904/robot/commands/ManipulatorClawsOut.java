package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ManipulatorClawsOut extends SolenoidExtend {
	public ManipulatorClawsOut() {
		super("ManipulatorClawsOut", RobotMap.Component.manipulator.claws);
	}
}