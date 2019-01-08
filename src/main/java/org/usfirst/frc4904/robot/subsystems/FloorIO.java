
package org.usfirst.frc4904.robot.subsystems;


// import org.usfirst.frc4904.robot.commands.IndexerGrabberClasp;
import org.usfirst.frc4904.robot.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FloorIO {

    public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;

	public final Motor hatcherRollerIntake;
	public final Motor cargoRollerIntake;
	public final HatchHolder hatchHolder;
	public final Flipper flipper;


	public FloorIO (Motor hatcherRollerIntake, Motor cargoRollerIntake, HatchHolder hatchHolder, Flipper flipper) {
		this.hatcherRollerIntake = hatcherRollerIntake;
		this.hatchHolder = hatchHolder;
		this.flipper = flipper

    }
    
    public static class HatchHolder extends Subsystem {
        public static final DoubleSolenoid.Value HELD = DoubleSolenoid.Value.kForward;
        public static final DoubleSolenoid.Value RELEASED = DoubleSolenoid.Value.kReverse;
        protected final DoubleSolenoid hatchHolder;

        public HatchHolder(DoubleSolenoid hatchHolder) {
			super("FloorIO Velcro");
            this.hatchHolder = hatchHolder;
            
        }
        
        public boolean isHeld() {
			return this.hatchHolder.get() == HELD;
		}

		public void set(boolean held) {
			if (held) {
				this.hatchHolder.set(HELD);
			} else {
				this.hatchHolder.set(RELEASED);
			}
		}

		
		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new IndexerVelcroTapeVelcroed());
		}
        
        
	}
	
    public static class Flipper extends Subsystem {
		public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kForward;
        public static final DoubleSolenoid.Value DOWN = DoubleSolenoid.Value.kReverse;
        protected final DoubleSolenoid flipper;

        public Flipper(DoubleSolenoid flipper) {
			super("FloorIO Flipper");
            this.flipper = flipper;
            
        }
        
        public boolean isTurned() {
			return this.flipperTurned.get() == UP;
		}

		public void set(boolean turned) {
			if (turned) {
				this.velcroTurned.set(UP);
			} else {
				this.velcroTurned.set(DOWN);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new IndexerVelcroTurnUnTurned());
		}
        
	}
}