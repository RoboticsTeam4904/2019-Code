package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.Util;

public class ClawsUp extends RunIfElse {
	public ClawsUp() {
		super(
			new SolenoidRetract("Claws Up", RobotMap.Component.manipulator.claws),
			new KittenCommand("Cannot flip claws up due to rollers spinning.", LogKitten.KittenLevel.WTF),
			() -> Util.isZero(RobotMap.Component.manipulator.roller.get())
		);
	}
}