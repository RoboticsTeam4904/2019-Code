package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Manipulator {
	public static final double INTAKE_SPEED = -1; //TODO: change these
	public static final double OUTTAKE_SPEED = -1;
	public static final double KEEP_BALL_SPEED = -1;
	public static final double INTAKE_TIME = -1;
	public static final double OUTTAKE_TIME = -1;
	public static final double STOP_TIME = -1;
	public final SolenoidSubsystem arm; // manipulator arm
	public final SolenoidSubsystem claws; // cargo skid
	public final SolenoidSubsystem hatchExtender; // the ground intake 
	public final SolenoidSubsystem grabber; // the hatch grabber 
	public final Motor roller; // IO rollers

	public Manipulator(SolenoidSubsystem arm, SolenoidSubsystem claws, SolenoidSubsystem groundPiston, SolenoidSubsystem grabber, Motor roller) {
		this.arm = arm;
		this.claws = claws;
		this.hatchExtender = groundPiston;
		this.grabber = grabber;
		this.roller = roller;
	}
}