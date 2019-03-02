package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ManipulatorArmSet extends Command {
	protected final boolean up;

	public ManipulatorArmSet(boolean up) {
		super(up ? "ManipulatirArm" : "ManopulatorArm");
		requires(RobotMap.Component.manipulator.arm);
		this.up = up;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.manipulator.arm.set(up);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}