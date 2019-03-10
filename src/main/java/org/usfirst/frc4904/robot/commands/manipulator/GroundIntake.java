package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.Command;


/** 
 * Prepares the manipulator for intake by lowering the claw and rolling the rollers in
 */
public class GroundIntake extends RunIfElse {

	private static double ROLLER_WAIT_TIME = 0.254; // TODO: find actual value

	public GroundIntake() {
		super(
			new ReadyGroundIntake(),
			new KittenCommand("Cannot flip claws down due to extension of the ground piston.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.hatchExtender.getState() == SolenoidState.RETRACT);
	}

	public static class ReadyGroundIntake extends CommandGroup {
		public ReadyGroundIntake() {
			addParallel(new WristDown());
			addParallel(new ClawsDown());
			addSequential(new WaitCommand(ROLLER_WAIT_TIME));
			addSequential(new RollerIn());
		}

		@Override
		protected void interrupted() {
			Command intake = new StopGroundIntake();
			intake.start();
		}
	}

	/**
	 * Returns the manipulator to its original position after intaking
	 */
	public static class StopGroundIntake extends CommandGroup {
		public StopGroundIntake() {
			addParallel(new WristUp());
			addParallel(new RollerKeepBall());
		}
	}
}