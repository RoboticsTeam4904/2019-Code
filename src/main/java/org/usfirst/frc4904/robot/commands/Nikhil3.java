package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Nikhil3 extends CommandGroup {
	public Nikhil3() {
		addSequential(new ManipulatirGrabber());
		addSequential(new ManopulatorGround());
		addSequential(new ManopulatorClaws());
		addSequential(new ManipulatirGrabber());
		// time.sleep(0.5)
		addSequential(new ManipulatirGround());
		addSequential(new ManopulatorClaws());
	}
}