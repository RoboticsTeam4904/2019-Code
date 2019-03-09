package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

public class ManipulatorGroundIn extends RunIfElse {
	public ManipulatorGroundIn() {
		super(
			new SolenoidRetract("ManipulatorGroundIn", RobotMap.Component.manipulator.groundPiston),
			new KittenCommand("Cannot retract ground piston due to hatch.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.grabber.getState() == SolenoidState.RETRACT
		);
	}
}