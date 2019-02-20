package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

/**
 * Retracts the hatch outtake piston
 */
public class HatchOuttakeRetract extends SolenoidRetract {
	public HatchOuttakeRetract() {
		super("HatchOuttakeRetract", RobotMap.Component.floorio.hatchOuttakePiston);
	}
}