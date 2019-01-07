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
}