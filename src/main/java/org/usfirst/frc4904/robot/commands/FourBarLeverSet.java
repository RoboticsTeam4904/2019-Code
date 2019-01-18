package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class FourBarLeverSet extends Command {
	protected final boolean up;

	public FourBarLeverSet(boolean up) {
		super(up ? "FourBarLeverUp" : "FourBarLeverDown");
		requires(RobotMap.Component.fourBar);
		this.up = up;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.fourBar.set(up);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}