package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.PusherRetract;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ProngIO {
    //Will change speeds as needed.
	public static final double EXPANSION_SPEED = 0.5;
	public static final double CONTRACTION_SPEED = -0.5;
	public final Motor expander;
	public final Pusher pusher;


	public ProngIO(Motor expander, Pusher pusher) {
		this.expander = expander;
		this.pusher = pusher;
	}

	public static class Pusher extends Subsystem {
		public static final DoubleSolenoid.Value FIRED = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value RETRACTED = DoubleSolenoid.Value.kReverse; //TODO: Change based on solenoid diretions.
		protected final DoubleSolenoid pusher;

		public Pusher(DoubleSolenoid pusher) {
			super("ProngIO Pusher");
			this.pusher = pusher;
		}

		public void set(boolean fired) {
			if (fired){ 
				this.pusher.set(FIRED);
			}
			else {
				this.pusher.set(RETRACTED);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new PusherRetract());
		}
	}
}
