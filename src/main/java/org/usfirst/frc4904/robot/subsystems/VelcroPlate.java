package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.VelcroPlateRest;
import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.commands.Noop;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VelcroPlate {
	public final SolenoidWrapper placeSolenoid;
	public final SolenoidWrapper pickupSolenoid;

	public class SolenoidWrapper extends Subsystem {
		public final DoubleSolenoid solenoid;
		public final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
		public final DoubleSolenoid.Value RELEASED = DoubleSolenoid.Value.kReverse;

		public SolenoidWrapper(DoubleSolenoid solenoid) {
			this.solenoid = solenoid;
		}

		public void set(boolean state) {
			if(state) {
				this.solenoid.set(EXTENDED);
			} else {
				this.solenoid.set(RELEASED);
			}
		}

		public boolean isExtended() {
			return this.solenoid.get() == EXTENDED;
		}

		public void initDefaultCommand() {
			setDefaultCommand(new Idle(this));
		}
	}

	public VelcroPlate(DoubleSolenoid pickupSolenoid, DoubleSolenoid placeSolenoid) {
		this.placeSolenoid = new SolenoidWrapper(placeSolenoid);
		this.pickupSolenoid = new SolenoidWrapper(pickupSolenoid);
	}
}