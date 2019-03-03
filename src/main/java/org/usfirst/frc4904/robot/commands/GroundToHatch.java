package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroundToHatch extends CommandGroup {
	public GroundToHatch() {
		addSequential(new ManipulatorGrabberOut());
		addSequential(new ManipulatorGroundOut());
		addSequential(new ElevatorUp());
		addSequential(new ManipulatorGroundIn());
		addSequential(new ElevatorDown());
	}
}