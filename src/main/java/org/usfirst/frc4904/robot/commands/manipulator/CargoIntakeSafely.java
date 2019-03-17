package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class CargoIntakeSafely extends CommandGroup {
	public CargoIntakeSafely() {
		addParallel(new HatchGrabberIn());
		addSequential(new WaitCommand(0.1));
		addParallel(new ClawsDown());
		addParallel(new WristDown());
		addParallel(new RollerIn());

	}
}