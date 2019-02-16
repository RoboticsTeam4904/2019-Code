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
	public final Motor hatcherRollerIntake;
	public final Motor cargoRollerIntake;
	public final SolenoidSubsystem hatchOuttakePiston;
	public final SolenoidSubsystem velcroPiston;
	public final SolenoidSubsystem wrist;

	public FloorIO(SolenoidSubsystem hatchOuttakePiston, SolenoidSubsystem velcroPiston, SolenoidSubsystem wrist,
		Motor hatcherRollerIntake, Motor cargoRollerIntake) {
		this.hatchOuttakePiston = hatchOuttakePiston;
		this.velcroPiston = velcroPiston;
		this.wrist = wrist;
		this.hatcherRollerIntake = hatcherRollerIntake;
		this.cargoRollerIntake = cargoRollerIntake;
	}
}
