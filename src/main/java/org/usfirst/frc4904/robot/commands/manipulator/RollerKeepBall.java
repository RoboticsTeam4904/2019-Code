package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.subsystems.Manipulator;

public class RollerKeepBall extends RollerSet {
	public RollerKeepBall() {
		super("RollerKeepBall", Manipulator.KEEP_BALL_SPEED);
	}
}