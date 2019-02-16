package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

/**
 * This command sets the state of the associated group to released.
 */
public class PushPistonRetract extends SolenoidRetract {
	public PushPistonRetract() {
		super("PlaceSolenoidDown", RobotMap.Component.floorio.pushPiston);
	}
}