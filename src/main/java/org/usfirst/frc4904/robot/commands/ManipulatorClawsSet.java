package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ManipulatorClawsSet extends Command {
	protected final boolean up;

	public ManipulatorClawsSet(boolean up) {
		super(up ? "ManipulatirClaws" : "ManopulatorClaws");
		requires(RobotMap.Component.manipulator.claws);
		this.up = up;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.manipulator.claws.set(up);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}