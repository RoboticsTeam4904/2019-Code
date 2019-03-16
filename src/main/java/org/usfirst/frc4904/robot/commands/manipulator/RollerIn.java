package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.subsystems.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class RollerIn extends RollerSet {
	public RollerIn() {
		super("RollerIn", Manipulator.INTAKE_SPEED);
	}

	@Override
	protected void interrupted() {
		Command command = new RollerKeepBall();
		command.start();
	}
}