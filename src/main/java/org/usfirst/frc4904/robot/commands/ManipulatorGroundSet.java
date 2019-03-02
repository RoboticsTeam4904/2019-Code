package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ManipulatorGroundSet extends Command {
	protected final boolean up;

	public ManipulatorGroundSet(boolean up) {
		super(up ? "ManipulatirGround" : "ManopulatorGround");
		requires(RobotMap.Component.manipulator.ground);
		this.up = up;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.manipulator.ground.set(up);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}