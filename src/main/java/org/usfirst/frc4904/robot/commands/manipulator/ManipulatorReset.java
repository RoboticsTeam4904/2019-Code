package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ManipulatorReset extends CommandGroup {
	public static double CLAWS_THEN_EXTENDER_DELAY = 0.3;

	public ManipulatorReset() {
		addParallel(new RollerStop());
		addParallel(new HatchGrabberIn());
		addParallel(new ClawsUp());
		addSequential(new WaitCommand(CLAWS_THEN_EXTENDER_DELAY));
		addParallel(new HatchExtenderIn());
		addParallel(new WristUp());
	}
}