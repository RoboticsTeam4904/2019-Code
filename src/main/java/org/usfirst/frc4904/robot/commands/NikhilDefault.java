package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class NikhilDefault extends CommandGroup {
	public NikhilDefault() {
		addSequential(new ManipulatirGround());
		addSequential(new ManopulatorGrabber());
		addSequential(new ManipulatirGrabber());
		addSequential(new ManipulatirClaws());
	}
}