package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

public class HatchExtenderOut extends RunIfElse {
	public HatchExtenderOut() {
		super(
			new SolenoidExtend("HatchExtenderOut", RobotMap.Component.manipulator.hatchExtender),
			new KittenCommand("Cannot extend ground piston due to claws.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT
		);
	}
}