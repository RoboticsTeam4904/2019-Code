package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


/**
 * IntakeRollersIntake is a command
 * that makes the cargo intake rollers
 * release the cargo (less forceful
 * than outtake)
 */

public class ReleaseIntake extends CommandGroup {
	private static final double RELEASE_SPEED = 0.3;
	private static final double RELEASE_TIME = 0.5;

	public ReleaseIntake() {
		addSequential(
			new RunFor(new MotorConstant(RobotMap.Component.cargoIORollerRight, RELEASE_SPEED), RELEASE_TIME));
		addSequential(
			new RunFor(new MotorConstant(RobotMap.Component.cargoIORollerLeft, RELEASE_SPEED), RELEASE_TIME));
	}
}