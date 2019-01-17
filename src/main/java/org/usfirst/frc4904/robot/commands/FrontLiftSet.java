package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class FrontLiftSet extends Command {
	protected final boolean clasped;

	public FrontLiftSet(boolean clasped) {
		super(clasped ? "FrontLiftRetract" : "FrontLiftExtend");
		requires(RobotMap.Component.climber.frontLift);
		this.clasped = clasped;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.climber.frontLift.set(clasped);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
