package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerVelcroHeldSet extends Command {
	protected final boolean held;

	public IndexerVelcroHeldSet(boolean held) {
		// IndexerVelcroHeldSet is code for the piston that holds the hatcher
		super(held ? "IndexerVelcroTapeHeld" : "IndexerVelcroTapeRelease");
		requires(RobotMap.Component.Floorio.floorio.hatchHolder);
		this.held = held;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.Floorio.floorio.hatchHolder.set(held);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
