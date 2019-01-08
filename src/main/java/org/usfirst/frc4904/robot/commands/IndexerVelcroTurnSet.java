package main.java.org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class IndexerVelcroTurnSet extends Command {
	protected final boolean turned;

	public IndexerVelcroTurnSet(boolean turned) {
		super(turned ? "IndexerVelcroTurnTurned" : "IndexerVelcroTurnUnTurned");
		requires(RobotMap.Component.HatchIO.velcroTurn);
		this.turned = turned;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.hatchIO.flipper.set(turned);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
