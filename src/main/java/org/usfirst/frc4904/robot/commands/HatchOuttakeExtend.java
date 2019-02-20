package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

/**
 * Extends the hatch outtake piston, outtaking a hatch
 */
public class HatchOuttakeExtend extends SolenoidExtend {
	public HatchOuttakeExtend() {
		super("HatchOuttakeExtend", RobotMap.Component.floorio.hatchOuttakePiston);
	}
}