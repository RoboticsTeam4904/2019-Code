package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroundIntake extends CommandGroup {
	public GroundIntake() {
		addSequential(new HatchExtenderIn());
		addSequential(new ManipulatorRollerIn());
		addSequential(new HatchExtenderIn());
		addSequential(new ManipulatorRollerStop());
	}
}