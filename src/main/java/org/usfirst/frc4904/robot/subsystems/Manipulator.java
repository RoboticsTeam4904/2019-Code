package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Manipulator {
	public static final double INTAKE_SPEED = -1; //not actually the real speeds or times
	public static final double OUTTAKE_SPEED = -1;
	public static final double STOP_SPEED = 0;
	public static final double INTAKE_TIME = -1;
	public static final double OUTTAKE_TIME = -1;
	public static final double STOP_TIME = -1;
	public final SolenoidSubsystem arm; // manipulator arm
	public final SolenoidSubsystem claws; // cargo skid
	public final SolenoidSubsystem ground; // the ground intake thing? idk
	public final SolenoidSubsystem grabber; // the hatch grabber thing? idk
	public final Motor roller; // the wheels

	public Manipulator(SolenoidSubsystem arm, SolenoidSubsystem claws, SolenoidSubsystem ground, SolenoidSubsystem grabber, Motor roller) {
		this.arm = arm;
		this.claws = claws;
		this.ground = ground;
		this.grabber = grabber;
		this.roller = roller;
	}
}