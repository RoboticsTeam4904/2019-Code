package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class NikhilDefault extends CommandGroup {
	public NikhilDefault() {
		addSequential(new SolenoidRetract("ManipulatorGroundIn", RobotMap.Component.manipulator.groundPiston));
		addSequential(new SolenoidExtend("ManipulatorGrabberOut", RobotMap.Component.manipulator.grabber));
		addSequential(new SolenoidRetract("ManipulatorGrabberIn", RobotMap.Component.manipulator.grabber));
		addSequential(new SolenoidRetract("ManipulatorClawsIn", RobotMap.Component.manipulator.claws));
	}
}