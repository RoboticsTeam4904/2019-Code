package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 *
 */
public class GripperIO {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public final Motor gripper;
	public final Extender extender;

	public GripperIO(Motor gripper, Extender extender) {
		this.gripper = gripper;
		this.extender = extender; 
	}

	// public void initDefaultCommand() {
	// 	// Set the default command for a subsystem here.
	// 	// setDefaultCommand(new MySpecialCommand());
	// }

	public static class Extender extends Subsystem {
		public static final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value RETRACTED = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid extender;

		public Grabber(DoubleSolenoid extender) {
			super("GripperIO Extender");
			this.extender = extender;
		}

		public void set(boolean extended) {
			if (extended) this.extender.set(EXTENDED);
			else this.extender.set(RETRACTED);
		}

		@Override
		protected void initDefaultCommand() {
			// setDefaultCommand(new IndexerGrabberClasp());
		}
	}
}