package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PistonGroupSet extends Command {
	protected final boolean clasped;

	public PistonGroupSet(boolean clasped) {
		requires(RobotMap.Component.velcroPlate.pistonGroup);
		this.clasped = clasped;
	}

	// Called just before this Command runs the first time
   	@Override
	protected void initialize() {
		System.out.println("The command has initialized!");
		RobotMap.Component.velcroPlate.pistonGroup.set(this.clasped);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}