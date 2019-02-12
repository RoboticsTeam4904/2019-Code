package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FloorIO {
	public static final double HATCH_INTAKE_SPEED = 0.5; // TODO: Tune these values
	public static final double HATCH_OUTTAKE_SPEED = -0.5;
	public static final double CARGO_INTAKE_SPEED_TOP = 0.5;
	public static final double CARGO_OUTTAKE_SPEED_TOP = -0.5;
	public static final double CARGO_INTAKE_SPEED_BOTTOM = -0.5;
	public static final double CARGO_OUTTAKE_SPEED_BOTTOM = 0.5;
	public final Motor hatcherRollerIntake;
	public final Motor cargoRollerIntake;
	public final SolenoidSubsystem pushPiston;
	public final SolenoidSubsystem velcroPiston;
	public final SolenoidSubsystem flipper;

	public FloorIO(SolenoidSubsystem pushPiston, SolenoidSubsystem velcroPiston, SolenoidSubsystem flipper,
		Motor hatcherRollerIntake, Motor cargoRollerIntake) {
		this.pushPiston = pushPiston;
		this.velcroPiston = velcroPiston;
		this.flipper = flipper;
		this.hatcherRollerIntake = hatcherRollerIntake;
		this.cargoRollerIntake = cargoRollerIntake;
	}
}
