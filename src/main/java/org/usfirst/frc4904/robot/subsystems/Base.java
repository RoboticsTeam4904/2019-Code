package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.robot.commands.BaseLowered;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class Base extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public static final DoubleSolenoid.Value LOWERED = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value RAISED = DoubleSolenoid.Value.kReverse;
	public final DoubleSolenoid frontLift;

	public Base(DoubleSolenoid frontLift) {
		super("Base");
		this.frontLift = frontLift;
	}

	public void set(boolean lowered) {
		if(lowered) this.frontLift.set(LOWERED);
		else this.frontLift.set(RAISED);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new BaseLowered());
	}
}