package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

/**
 * This command sets the state of the associated group to released.
 */
public class PlaceSolenoidUp extends SolenoidExtend {
	public PlaceSolenoidUp() {
		super("PlaceSolenoidUp", RobotMap.Component.placeSolenoid);
    }
}