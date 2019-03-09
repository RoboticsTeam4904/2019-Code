package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Gets robot ready to intake hatch
 */
public class ReadyHatchIntake extends RunIf {
	public ReadyHatchIntake() {
		super(
			new ReadyHatchIntakeDangerously(),
			() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT
		);
	}
	public static class ReadyHatchIntakeDangerously extends CommandGroup {
		public ReadyHatchIntakeDangerously() {
			addParallel(new ManipulatorArmUp());
			addParallel(new ManipulatorClawsUp());
			addParallel(new HatchExtenderOut());
			addParallel(new ManipulatorGrabberIn());
		}
	}
}