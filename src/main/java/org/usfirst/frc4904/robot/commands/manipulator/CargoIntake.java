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
public class CargoIntake extends RunIfElse {
	private static double ROLLER_WAIT_TIME = 0.1; // TODO: find actual value

	public CargoIntake() {
		super(new ReadyGroundIntakeDangerously(),
			new KittenCommand("Cannot flip claws down because we grabber has a hatch.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.hatchGrabber.getState() == SolenoidState.RETRACT);
	}

	public static class ReadyGroundIntakeDangerously extends CommandGroup {
		public ReadyGroundIntakeDangerously() {
			addParallel(new HatchExtenderIn());
			// addSequential(new WaitCommand())
			addParallel(new WristDown());
			addParallel(new ClawsDown());
			addSequential(new WaitCommand(ROLLER_WAIT_TIME));
			addSequential(new RollerIn());
		}

		@Override
		protected void interrupted() {
			Command finishIntake = new FinishGroundIntake();
			finishIntake.start();
		}
	}

	/**
	 * Returns the manipulator to its original position after intaking
	 */
	public static class FinishGroundIntake extends CommandGroup {
		public FinishGroundIntake() {
			addParallel(new ClawsDown());
			addParallel(new WristUp());
			addParallel(new RollerKeepBall());
			addParallel(new HatchExtenderIn());
		}
	}
}