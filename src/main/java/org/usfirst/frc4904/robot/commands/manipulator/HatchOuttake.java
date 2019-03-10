package org.usfirst.frc4904.robot.commands.manipulator;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class HatchOuttake extends CommandGroup {
	public final double GRABBER_WAIT_TIME = 1;

	public HatchOuttake() {
		super("ReadyHatchOuttake");
		addParallel(new HatchGrabberIn());
		addParallel(new HatchExtenderOut());
		addSequential(new WaitCommand(GRABBER_WAIT_TIME));
		addParallel(new HatchExtenderIn());
	}
}