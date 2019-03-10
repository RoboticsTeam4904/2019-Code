package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class HatchOuttake extends CommandGroup {
	public final double GRABBER_WAIT_TIME = 0.4;
	public final double CLAWS_WAIT_TIME = 0.3;

	public HatchOuttake() {
		super("ReadyHatchOuttake");
		addParallel(new HatchGrabberIn());
		addSequential(new WaitCommand(GRABBER_WAIT_TIME));
		addParallel(new HatchExtenderIn());
		addSequential(new WaitCommand(CLAWS_WAIT_TIME));
		addParallel(new ClawsDown());
	}
}