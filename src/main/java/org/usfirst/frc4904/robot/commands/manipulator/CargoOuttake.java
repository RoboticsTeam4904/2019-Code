package org.usfirst.frc4904.robot.commands.manipulator;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class CargoOuttake extends CommandGroup {
	public final double CLAW_WAIT_TIME = 2;

	public CargoOuttake() {
		addParallel(new RollerOut());
		addSequential(new WaitCommand(CLAW_WAIT_TIME));
		addSequential(new ClawsUp());
	}
}