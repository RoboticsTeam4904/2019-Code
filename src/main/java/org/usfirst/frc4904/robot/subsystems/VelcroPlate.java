package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.commands.PistonGroupRelease;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * The default position of the pistons is in its "RELEASED" state,
 * with the motor in the upright position. The mechanism works by
 * doing the following actions in this order:
 * (1) Rotate the plate to the floor to pick up the hatch via Velcro.
 *     No pistons should change state during this process.
 * (2) Rotate back to the upright position.
 * (3) Drive over to the hatch port location.
 * (4) Attach the hatch to the location via piston extension, then after a split second drive away.
 *     This places the hatch in its target port.
 * (5) Release pistons to reset the process.
 */

public class VelcroPlate {
	public final Motor motor;
	public final PistonGroup pistonGroup;
	public static final double MOTOR_SPEED = 0.7;

	public VelcroPlate(Motor motor, PistonGroup pistonGroup) {
		this.motor = motor;
		this.pistonGroup = pistonGroup;
	}

	public class PistonGroup extends Subsystem {
		public static final DoubleSolenoid.Value CLASPED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value RELEASED = DoubleSolenoid.Value.kReverse;
		public final DoubleSolenoid solenoid;

		public PistonGroup(DoubleSolenoid solenoid) {
			super("PistonGroup");
			this.solenoid = solenoid;
		}

		public boolean isClasped() {
			return this.solenoid.get() == CLASPED;
		}

		public void set(boolean clasped){
			if(clasped) {
				this.solenoid.set(CLASPED);
			} else {
				this.solenoid.set(RELEASED);
			}
		}

		public void initDefaultCommand() {
			// Set the default command for a subsystem here.
			// setDefaultCommand(new MySpecialCommand());
			setDefaultCommand(new PistonGroupRelease());
		}
	}
}