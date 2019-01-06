package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.robot.commands.IndexerGrabberClasp;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchIO {

    public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;

	public final Motor roller;
	public final VelcroTape velcroTape;

	public HatchIO(Motor roller, VelcroTape velcroTape) {
		this.roller = roller;
		this.velcroTape = velcroTape;
    }
    
    public static class VelcroTape extends Subsystem {
        public static final DoubleSolenoid.Value VELCROED = DoubleSolenoid.Value.kForward;
        public static final DoubleSolenoid.Value UNVELCROED = DoubleSolenoid.Value.kReverse;
        protected final DoubleSolenoid velcroTape;

        public VelcroTape(DoubleSolenoid velcroTape) {
			super("HatchIO Velcro");
            this.velcroTape = velcroTape;
            
        }
        
        public boolean isVelcroed() {
			return this.velcroTape.get() == VELCROED;
		}

		public void set(boolean velcroed) {
			if (velcroed) {
				this.velcroTape.set(VELCROED);
			} else {
				this.velcroTape.set(UNVELCROED);
			}
        }
        
        
    }
}