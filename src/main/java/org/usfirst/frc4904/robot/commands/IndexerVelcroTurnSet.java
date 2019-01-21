package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerVelcroTurnSet extends Command {
	protected final boolean turned;

	public IndexerVelcroTurnSet(boolean turned) {
		super(turned ? "IndexerVelcroUp" : "IndexerVelcroDown", RobotMap.Component.Floorio.floorio.flipper); // See PR #5 comments.
		this.turned = turned;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.Floorio.floorio.flipper.set(turned);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
