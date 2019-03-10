package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Returns the manipulator to its original position after intaking
 */
public class StopGroundIntake extends CommandGroup {
	public StopGroundIntake() {
		addParallel(new WristUp());
		addParallel(new RollerKeepBall());
		
	}
}