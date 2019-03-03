package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Nikhil2 extends CommandGroup {
	public Nikhil2() {
		addSequential(new ManopulatorGrabber());
	}
}