package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class OuttakePegSet extends Command {
	protected final boolean extended;

	public OuttakePegSet(boolean extended) {
		super(extended ? "OuttakePegExtend" : "OuttakePegRetract");
		requires(RobotMap.Component.hatchOuttakePeg.peg);
		this.extended = extended;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.hatchOuttakePeg.peg.set(extended);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
