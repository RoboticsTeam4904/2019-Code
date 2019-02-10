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
	public static final double CARGO_INTAKE_SPEED = 0.5;
	public static final double CARGO_OUTTAKE_SPEED = -0.5;
	public final Motor hatcherRollerIntake;
	public final SolenoidSubsystem placeSolenoid;
	public final SolenoidSubsystem pickupSolenoid;
	public final SolenoidSubsystem flipper;

	public FloorIO(SolenoidSubsystem placeSolenoid, SolenoidSubsystem pickupSolenoid, SolenoidSubsystem flipper, Motor hatcherRollerIntake) {
		this.placeSolenoid = placeSolenoid;
		this.pickupSolenoid = pickupSolenoid;
		this.flipper = flipper;
		this.hatcherRollerIntake = hatcherRollerIntake;
	}
}
