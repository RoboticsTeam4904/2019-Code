package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

/**
 * This command sets the state of the associated group to released.
 */
public class PickupSolenoidDown extends SolenoidRelease {
	public PickupSolenoidDown() {
		super("PickupSolenoidDown", RobotMap.Component.pickupSolenoid);
    }
}