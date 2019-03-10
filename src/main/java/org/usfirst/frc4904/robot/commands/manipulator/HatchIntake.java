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
			() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT);
	}

	public static class ReadyHatchIntakeDangerously extends CommandGroup {
		public ReadyHatchIntakeDangerously() {
			addParallel(new ManipulatorArmUp());
			addParallel(new ManipulatorClawsUp());
			addParallel(new HatchExtenderOut());
			addParallel(new ManipulatorGrabberIn());
		}

		@Override
		protected void interrupted() {
			Command hatchIntake = new RunIf(new ManipulatorGrabberOut(),
				() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT);
			hatchIntake.start();
		}
	}
}