package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BaseSet extends Command {
	protected final boolean lowered;

	public BaseSet(boolean lowered) {
		// Use requires() here to declare subsystem dependencies
		super(lowered ? "BaseLowered" : "BaseRaised");
		requires(RobotMap.Component.base);
		this.lowered = lowered;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("The command has initialized!");
		RobotMap.Component.base.set(lowered);
	}

	// Called repeatedly when this Command is scheduled to run
	// @Override
	// protected void execute() {
		// Do you want to set the speed of a motor here? Check this out:
		// https://github.com/RoboticsTeam4904/standard/blob/cc66c21f46c1dd15b7150a66ae2e85cd06ef8f72/subsystems/motor/Motor.java#L231
	// }

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	// @Override
	// protected void end() {
	// }

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	// @Override
	// protected void interrupted() {
	// }
}