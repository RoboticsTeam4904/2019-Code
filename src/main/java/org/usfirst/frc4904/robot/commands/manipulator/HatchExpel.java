package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class HatchExpel extends CommandGroup {
	public static double WAIT_TIME_BEFORE_CLAWS_UP = 1; // seconds
	public static double WAIT_TIME_BEFORE_GRABBER_IN = 0.1; // seconds

	public HatchExpel() {
		addSequential(new SolenoidExtend("Claws Down", RobotMap.Component.manipulator.claws));
		addSequential(new WaitCommand("Wait for grabber in", WAIT_TIME_BEFORE_GRABBER_IN));
		addSequential(new HatchGrabberIn());
		addSequential(new WaitCommand("Wait for claws up", WAIT_TIME_BEFORE_CLAWS_UP));
		addSequential(new SolenoidRetract("Claws Up", RobotMap.Component.manipulator.claws));
	}
}