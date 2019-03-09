package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.standard.commands.RunFor;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroundIntake extends CommandGroup {
	public GroundIntake() {
		addSequential(new RunFor(new ManipulatorGroundOut(), 0.5));
		addSequential(new ManipulatorRollerIn());
		addSequential(new ManipulatorGroundIn());
		addSequential(new ManipulatorRollerStop());
	}
}