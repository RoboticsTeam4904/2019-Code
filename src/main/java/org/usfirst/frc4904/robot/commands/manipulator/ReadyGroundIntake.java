package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorUp;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorDown;

public class ReadyGroundIntake extends CommandGroup {
	public ReadyGroundIntake() {
		addSequential(new ElevatorUp());
		addSequential(new ManipulatorGroundOut());
		addSequential(new ElevatorDown());
		addSequential(new ManipulatorGroundIn());
	}
}