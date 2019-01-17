package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class BackLiftSet extends Command {
	protected final boolean clasped;

	public BackLiftSet(boolean clasped) {
		super(clasped ? "BackLiftRetract" : "BackLiftExtend");
		requires(RobotMap.Component.climber.backLift);
		this.clasped = clasped;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.climber.backLift.set(clasped);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
