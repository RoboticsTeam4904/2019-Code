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
	private static double ROLLER_WAIT_TIME = 0.1;
	public static double WRIST_UP_WAIT_TIME = 0.2;

	public CargoIntake() {
		super(new ReadyGroundIntakeDangerously(),
			new KittenCommand("Cannot flip claws down because we grabber has a hatch.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.hatchGrabber.getState() == SolenoidState.RETRACT
				|| RobotMap.Component.manipulator.isOverridden()
		);
	}

	public static class ReadyGroundIntakeDangerously extends CommandGroup {
		private Command finishIntake;

		public ReadyGroundIntakeDangerously() {
			addParallel(new HatchExtenderIn());
			// addSequential(new WaitCommand())
			addParallel(new WristDown());
			addParallel(new ClawsDown());
			addSequential(new WaitCommand(ROLLER_WAIT_TIME));
			addParallel(new RollerIn());
			finishIntake = new FinishGroundIntake();
		}

		@Override
		protected void interrupted() {
			finishIntake.start();
		}
	}

	/**
	 * Returns the manipulator to its original position after intaking
	 */
	public static class FinishGroundIntake extends CommandGroup {
		public FinishGroundIntake() {
			addParallel(new RollerKeepBall());
			addParallel(new ClawsDown());
			addSequential(new WaitCommand(WRIST_UP_WAIT_TIME));
			addParallel(new WristUp());
			// addParallel(new HatchExtenderIn());
		}
	}
}