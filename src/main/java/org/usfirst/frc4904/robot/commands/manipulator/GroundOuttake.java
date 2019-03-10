package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroundOuttake extends CommandGroup {
	public GroundOuttake() {
		addSequential(new RollerOut());
		
	}
}