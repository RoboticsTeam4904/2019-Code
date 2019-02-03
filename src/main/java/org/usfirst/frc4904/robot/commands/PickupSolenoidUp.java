package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

/**
 * This command sets the state of the associated group to released.
 */
public class PickupSolenoidUp extends SolenoidExtend {
	public PickupSolenoidUp() {
		super("PickupSolenoidUp", RobotMap.Component.pickupSolenoid);
    }
}