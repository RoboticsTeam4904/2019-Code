package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class FrontLiftSet extends Command {
	protected final boolean extended;

	public FrontLiftSet(boolean extended) {
		super(extended ?  "FrontLiftExtend" : "FrontLiftRetract", RobotMap.Component.climber.frontLift);
		this.extended = extended;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.climber.frontLift.set(extended);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
