package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class HatchExtenderOut extends SolenoidExtend {
	public HatchExtenderOut() {
		super("HatchExtenderOut", RobotMap.Component.manipulator.hatchExtender);
	}
}