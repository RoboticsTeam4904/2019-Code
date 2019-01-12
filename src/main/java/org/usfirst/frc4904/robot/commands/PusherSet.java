package org.usfirst.frc4904.robot.commands;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class PusherSet extends Command {
	protected final boolean fired;

	public PusherSet(boolean fired) {
		super(fired ? "PusherFire" : "PusherRetract");
		requires(RobotMap.Component.prongIO.pusher);
		this.fired = fired;
	}

	@Override
	protected void initialize() {
		RobotMap.Component.prongIO.pusher.set(fired);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
