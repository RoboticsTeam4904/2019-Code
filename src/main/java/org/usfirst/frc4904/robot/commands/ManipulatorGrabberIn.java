package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ManipulatorGrabberIn extends CommandGroup {
	public ManipulatorGrabberIn() {
		addSequential(new RunIfElse(
			new SolenoidRetract("ManipulatorGrabberIn", RobotMap.Component.manipulator.grabber),
			new KittenCommand("Cannot intake hatch due to cargo skid.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT
		));
	}
}