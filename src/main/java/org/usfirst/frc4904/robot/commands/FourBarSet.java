package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator.FourBarState;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Control elevator manually
 */
public class FourBarSet extends Command {
	public final FourBarState state;

	public FourBarSet(String name, FourBarState state) {
		super(name);
		requires(RobotMap.Component.fourBar.elevator);
		requires(RobotMap.Component.fourBar.lever);
		this.state = state;
	}

	public void initialize() {
		RobotMap.Component.fourBar.setPosition(state);
	}

	public boolean isFinished() {
		return false;
	}
}
