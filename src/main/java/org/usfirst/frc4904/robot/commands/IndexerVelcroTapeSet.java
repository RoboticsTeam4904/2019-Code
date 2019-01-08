package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerVelcroTapeSet extends Command {
	protected final boolean velcroed;

	public IndexerVelcroTapeSet(boolean velcroed) {
		super(velcroed ? "IndexerVelcroTapeVelcroed" : "IndexerVelcroTapeUnVelcroed");
		requires(RobotMap.Component.HatchIO.velcroTape);
		this.velcroed = velcroed;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.hatchIO.hatchHolder.set(velcroed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
