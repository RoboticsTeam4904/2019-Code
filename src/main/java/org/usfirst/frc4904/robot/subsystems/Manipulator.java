package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.manipulator.RollerDefault;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.Overridable;

public class Manipulator implements Overridable {
	public static final double INTAKE_SPEED = 0.6;
	public static final double OUTTAKE_SPEED = -0.75;
	public static final double KEEP_BALL_SPEED = 0.15;
	public final SolenoidSubsystem wrist; // flipper for whole manipulator
	public final SolenoidSubsystem claws; // cargo claws
	public final SolenoidSubsystem hatchExtender; // extend hatch grabber out of frame
	public final SolenoidSubsystem hatchGrabber; // the hatch grabber
	public final Motor roller; // CargoIO rollers
	public boolean isOverridden;

	public Manipulator(SolenoidSubsystem wrist, SolenoidSubsystem claws, SolenoidSubsystem hatchExtender,
		SolenoidSubsystem hatchGrabber, Motor roller, boolean overriden) {
		this.wrist = wrist;
		this.claws = claws;
		this.hatchExtender = hatchExtender;
		this.hatchGrabber = hatchGrabber;
		this.roller = roller;
		this.setOverridden(overriden);
	}

	public Manipulator(SolenoidSubsystem wrist, SolenoidSubsystem claws, SolenoidSubsystem hatchExtender,
		SolenoidSubsystem hatchGrabber, Motor roller) {
		this(wrist, claws, hatchExtender, hatchGrabber, roller, false);
	}

	public void setOverridden(boolean override) { // TODO: add to standard by default, but can override optionally (like in OverridableSubsystem)
		this.isOverridden = override;
	}

	public boolean isOverridden() {
		return isOverridden;
	}
}