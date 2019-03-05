package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Nikhil2 extends CommandGroup {
	public Nikhil2() {
		addSequential(new SolenoidExtend("ManipulatorGrabberOut", RobotMap.Component.manipulator.grabber));
	}
}