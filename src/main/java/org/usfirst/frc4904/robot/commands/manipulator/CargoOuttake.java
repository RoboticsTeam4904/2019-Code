package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CargoOuttake extends CommandGroup {
	public CargoOuttake() {
		addSequential(new RollerOut());
	}
}