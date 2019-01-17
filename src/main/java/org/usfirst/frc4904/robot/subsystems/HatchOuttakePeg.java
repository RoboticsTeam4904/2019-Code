package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class HatchOuttakePeg {
	public final Peg peg;

	public HatchOuttakePeg(Peg peg) {
		this.peg = peg;
	}

	public static class Peg extends Subsystem {
		public static final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value RETRACTED = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid peg;

		public Peg(DoubleSolenoid peg) {
			super("HatchOuttakePeg Peg");
			this.peg = peg;
		}

		public boolean isExtended() {
			return this.peg.get() == EXTENDED;
		}

		public void set(boolean extended) {
			if (extended) {
				this.peg.set(EXTENDED);
			} else {
				this.peg.set(RETRACTED);
			}
		}

		@Override
		protected void initDefaultCommand() {
		}
	}
}
