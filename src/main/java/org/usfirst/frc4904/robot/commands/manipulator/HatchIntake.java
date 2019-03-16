package org.usfirst.frc4904.robot.commands.manipulator;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * ReadyHatchIntakeDangerously: Just intakes the hatch, assumes that the claws are up.
 * HatchIntake Constructor: Makes sure that we can intake a hatch by only running when the claws are up.
 * Interrupted: After getting ready to intake a hatch, makes sure claws are up, and intakes hatch.
 */
public class HatchIntake extends RunIf {
	public HatchIntake() {
		super(
			new ReadyHatchIntakeDangerously(),
			() -> RobotMap.Component.manipulator.claws.getState() != SolenoidState.EXTEND
				|| RobotMap.Component.manipulator.isOverridden()
		);
	}

	public static class ReadyHatchIntakeDangerously extends CommandGroup {
		public ReadyHatchIntakeDangerously() {
			addParallel(new WristUp());
			addParallel(new ClawsUp());
			addParallel(new HatchExtenderOut());
			addParallel(new HatchGrabberIn());
		}

		@Override
		protected void interrupted() {
			Command finishIntake = new FinishHatchIntake();
			finishIntake.start();
		}
	}

	public static class FinishHatchIntake extends CommandGroup {
		public FinishHatchIntake() {
			addParallel(new HatchExtenderOut());
			addParallel(new HatchGrabberOut());
		}
	}
}