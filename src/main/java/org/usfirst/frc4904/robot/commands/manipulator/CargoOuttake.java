package org.usfirst.frc4904.robot.commands.manipulator;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class CargoOuttake extends RollerOut {

	public CargoOuttake() {
		super();
	}

	@Override
	protected void interrupted() {
		Command finishOuttake = new FinishCargoOuttake();
		finishOuttake.start();
	}

	public static class FinishCargoOuttake extends CommandGroup {
		public final double CLAW_WAIT_TIME = 1;

		public FinishCargoOuttake() {
			// Interruptable by other roller commands (due to requires)
			requires(RobotMap.Component.manipulator.roller);
			addSequential(new WaitCommand(CLAW_WAIT_TIME));
			addSequential(new ClawsUp());
		}
	}
}