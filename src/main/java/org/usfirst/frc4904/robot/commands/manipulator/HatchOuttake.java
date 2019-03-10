package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchOuttake extends CommandGroup {
	public HatchOuttake() {
		super("ReadyHatchOuttake");
		addParallel(new GrabberIn());
		addParallel(new HatchExtenderIn());
		addParallel(new ClawsDown());
	}
}