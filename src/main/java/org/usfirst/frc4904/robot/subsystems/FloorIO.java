package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;

public class FloorIO {
	public static final double HATCH_INTAKE_SPEED = 0.5; // TODO: Tune these values
	public static final double HATCH_OUTTAKE_SPEED = -0.5;
	public static final double CARGO_INTAKE_SPEED_TOP = 0.5;
	public static final double CARGO_OUTTAKE_SPEED_TOP = -0.5;
	public static final double CARGO_INTAKE_SPEED_BOTTOM = -0.5;
	public static final double CARGO_OUTTAKE_SPEED_BOTTOM = 0.5;
	public final Motor hatchRoller;
	public final Motor cargoRoller;
	public final SolenoidSubsystem pushPiston;
	public final SolenoidSubsystem velcroPiston;
	public final SolenoidSubsystem wrist;

	public FloorIO(SolenoidSubsystem pushPiston, SolenoidSubsystem velcroPiston, SolenoidSubsystem wrist,
		Motor hatchRoller, Motor cargoRoller) {
		this.pushPiston = pushPiston;
		this.velcroPiston = velcroPiston;
		this.wrist = wrist;
		this.hatchRoller = hatchRoller;
		this.cargoRoller = cargoRoller;
	}
}
