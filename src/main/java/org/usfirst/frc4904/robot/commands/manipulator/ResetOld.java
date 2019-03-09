package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ResetOld extends CommandGroup {
	public ResetOld() {
		addSequential(new SolenoidRetract("ManipulatorGrabberIn", RobotMap.Component.manipulator.grabber));
		addSequential(new SolenoidExtend("ManipulatorGroundOut", RobotMap.Component.manipulator.hatchExtender));
		addSequential(new SolenoidExtend("ManipulatorClawsOut", RobotMap.Component.manipulator.claws));
		addSequential(new SolenoidRetract("ManipulatorGrabberIn", RobotMap.Component.manipulator.grabber));
		addSequential(new WaitCommand(0.5));
		addSequential(new SolenoidRetract("ManipulatorGroundIn", RobotMap.Component.manipulator.hatchExtender));
		addSequential(new SolenoidExtend("ManipulatorClawsOut", RobotMap.Component.manipulator.claws));
	}
}