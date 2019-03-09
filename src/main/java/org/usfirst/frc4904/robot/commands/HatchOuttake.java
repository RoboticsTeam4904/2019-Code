package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchOuttake extends CommandGroup {
	public HatchOuttake() {
		super("ReadyHatchOuttake");
		addParallel(new ManipulatorGrabberIn());
		addParallel(new ManipulatorGroundOut());
		addParallel(new ManipulatorClawsDown());
	}
}