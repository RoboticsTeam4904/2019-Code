package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorUp;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorDown;

public class GroundToHatch extends CommandGroup {
	public GroundToHatch() {
		addSequential(new ManipulatorGrabberOut());
		addSequential(new ManipulatorGrabberIn());
		addSequential(new HatchExtenderIn());
		addSequential(new ElevatorUp());
		addSequential(new HatchExtenderIn());
		addSequential(new ElevatorDown());
	}
}