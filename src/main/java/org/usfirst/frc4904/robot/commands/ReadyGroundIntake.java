package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReadyGroundIntake extends CommandGroup {
	public ReadyGroundIntake() {
		addSequential(new ElevatorUp());
		addSequential(new ManipulatorGroundOut());
		addSequential(new ElevatorDown());
		addSequential(new ManipulatorGroundIn());
	}
}