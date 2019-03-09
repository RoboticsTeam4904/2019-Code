package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

public class HatchIntake extends RunIf {
	public HatchIntake() {
		super(
			new ManipulatorGrabberOut(),
			() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT
		);
	}
}