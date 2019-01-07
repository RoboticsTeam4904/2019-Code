package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 *
 */
public class VelcroRoller extends Subsystem {
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static final double SPEED = 0.5;
	public final Motor roller;

	public VelcroRoller(Motor roller) {
		this.roller = roller;
	}


	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}