package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ManipulatorGrabberSet extends Command {
	protected final boolean in;

	public ManipulatorGrabberSet(boolean in) {
		super(in ? "ManipulatirGround" : "ManopulatorGround");
		requires(RobotMap.Component.manipulator.ground);
		this.in = in;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.manipulator.ground.set(in);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}