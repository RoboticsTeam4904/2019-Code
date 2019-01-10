package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawIO {
	public final static double OUTTAKE_SPEED = .5;
	public final static double INTAKE_SPEED = -.5;

	public final Motor motorLeft;
	public final Motor motorRight;

	public ClawIO(Motor motorLeft, Motor motorRight) {
		this.motorLeft = motorLeft;
		this.motorRight = motorRight;
	}
}