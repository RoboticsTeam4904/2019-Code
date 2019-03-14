package org.usfirst.frc4904.robot.commands.manipulator;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

/**
 * If the manipulator is not retracted, run it at keep ball speed until it is retracted
 * If the manipulator is retracted, run it at 0 until it is not retracted
 */
public class RollerDefault extends RunUntil {
	public RollerDefault() {
		super(
			new RollerSet("RollerIn",
				RobotMap.Component.manipulator.claws.getState() != SolenoidState.RETRACT ? Manipulator.KEEP_BALL_SPEED : 0),
			RobotMap.Component.manipulator.claws.getState() != SolenoidState.RETRACT
				? () -> RobotMap.Component.manipulator.claws.getState() == SolenoidState.RETRACT
				: () -> RobotMap.Component.manipulator.claws.getState() != SolenoidState.RETRACT);
	}
}