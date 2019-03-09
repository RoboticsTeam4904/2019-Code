package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchIntake extends RunIf {
	public HatchIntake() {
		super(
			new HatchIntakeDangerously(),
			() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT
		);
	}
	public static class HatchIntakeDangerously extends CommandGroup {
		public HatchIntakeDangerously() {
			addSequential(new ManipulatorArmDown());
			addSequential(new ManipulatorGroundOut());
			addSequential(new ManipulatorGrabberOut());
			addSequential(new ManipulatorGrabberIn());
		}
	}
}