package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class RollerSetNeutral extends Command {
	
	public RollerSetNeutral() {
		requires(RobotMap.Component.manipulator.roller);
	}
	
	@Override
	protected void initialize() {
		RobotMap.Component.manipulatorRoller.neutralOutput();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}