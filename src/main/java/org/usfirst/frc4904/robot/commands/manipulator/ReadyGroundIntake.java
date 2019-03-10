package org.usfirst.frc4904.robot.commands.manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/** 
 * Prepares the manipulator for intake by lowering the claw and rolling the rollers in
 */
public class ReadyGroundIntake extends CommandGroup {

	private static double ROLLER_WAIT_TIME = 0.254; // TODO: find actual value

	public ReadyGroundIntake() {
		addParallel(new ManipulatorArmDown());
		addParallel(new ManipulatorClawsDown());
		addSequential(new WaitCommand(ROLLER_WAIT_TIME));
		addSequential(new ManipulatorRollerIn());
	}
}