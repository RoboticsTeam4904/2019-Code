package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class BackLiftSet extends Command {
	protected final boolean extended;

	public BackLiftSet(boolean extended) {
		super(extended ? "BackLiftExtend" : "BackLiftRetract", RobotMap.Component.climber.backLift);
		this.extended = extended;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.climber.backLift.set(extended);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
