package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class HatchOuttakePeg {
	public final Peg peg;

	public HatchOuttakePeg(Peg peg) {
		this.peg = peg;
	}

	public static class Peg extends Subsystem {
		public static final DoubleSolenoid.Value IN = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value OUT = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid peg;

		public Peg(DoubleSolenoid peg) {
			super("HatchOuttakePeg Peg");
			this.peg = peg;
		}

		public boolean isClasped() {
			return this.peg.get() == IN;
		}

		public void set(boolean clasped) {
			if (clasped) {
				this.peg.set(IN);
			} else {
				this.peg.set(OUT);
			}
		}

		@Override
		protected void initDefaultCommand() {
		}
	}
}
