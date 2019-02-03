package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

/**
 * This command sets the state of the associated group to released.
 */
public class PlaceSolenoidDown extends SolenoidRelease {
	public PlaceSolenoidDown() {
		super("PlaceSolenoidDown", RobotMap.Component.placeSolenoid);
    }
}