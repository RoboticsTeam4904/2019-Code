package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Manipulator {
	public static final double INTAKE_SPEED = 0.7;
	public static final double OUTTAKE_SPEED = -0.7;
	public static final double KEEP_BALL_SPEED = -0.1;
	public final SolenoidSubsystem wrist; // flipper for whole  manipulator
	public final SolenoidSubsystem claws; // cargo claws
	public final SolenoidSubsystem hatchExtender; // extend hatch grabber out of frame
	public final SolenoidSubsystem grabber; // the hatch grabber
	public final Motor roller; // CargoIO rollers

	public Manipulator(SolenoidSubsystem wrist, SolenoidSubsystem claws, SolenoidSubsystem groundPiston,
			SolenoidSubsystem grabber, Motor roller) {
		this.wrist = wrist;
		this.claws = claws;
		this.hatchExtender = groundPiston;
		this.grabber = grabber;
		this.roller = roller;
	}
}