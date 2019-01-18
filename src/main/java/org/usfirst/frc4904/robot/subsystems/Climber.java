package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.FrontLiftRetract;
import org.usfirst.frc4904.robot.commands.BackLiftRetract;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Climber {
    public final FrontLift frontLift;
    public final BackLift backLift;


	public Climber(FrontLift frontLift, BackLift backLift) {
		this.frontLift = frontLift;
		this.backLift = backLift;
	}

    public static class FrontLift extends Subsystem {
        public static final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
        public static final DoubleSolenoid.Value RETRACTED = DoubleSolenoid.Value.kReverse; //TODO: Change based on solenoid diretions.
        protected final DoubleSolenoid frontLift;

        public FrontLift(DoubleSolenoid frontLift) {
            super("ClimberFrontLift");
            this.frontLift = frontLift;
        }

        public void set(boolean extended) {
            if (extended){ 
                this.frontLift.set(EXTENDED);
            }
            else {
                this.frontLift.set(RETRACTED);
            }
        }
        @Override
		protected void initDefaultCommand() {
			setDefaultCommand(new FrontLiftRetract());
		}
    }
    public static class BackLift extends Subsystem {
        public static final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
        public static final DoubleSolenoid.Value RETRACTED = DoubleSolenoid.Value.kReverse; //TODO: Change based on solenoid diretions.
        protected final DoubleSolenoid backLift;

        public BackLift(DoubleSolenoid backLift) {
            super("ClimberBackLift");
            this.backLift = backLift;
        }

        public void set(boolean fired) {
            if (fired){ 
                this.backLift.set(EXTENDED);
            }
            else {
                this.backLift.set(RETRACTED);
            }
        }
		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new BackLiftRetract());
		}
    }

}