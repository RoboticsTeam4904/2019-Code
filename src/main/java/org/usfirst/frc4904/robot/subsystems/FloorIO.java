package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.IndexerVelcroDown;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.robot.subsystems.VelcroPlate;

public class FloorIO {
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public final Motor hatcherRollerIntake;
	public final Motor cargoRollerIntake;
	public final Flipper flipper;
	public final VelcroPlate velcroPlate;


	public FloorIO (Motor hatcherRollerIntake, Motor cargoRollerIntake, VelcroPlate hatchPlate, Flipper flipper) {
		this.hatcherRollerIntake = hatcherRollerIntake;
		this.cargoRollerIntake = cargoRollerIntake;
		this.flipper = flipper;
		this.velcroPlate = hatchPlate;

    }
	
    public static class Flipper extends Subsystem {
	    public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kForward; // Piston moves the block that holds the hatcher 90 degrees upwards 
	    public static final DoubleSolenoid.Value DOWN = DoubleSolenoid.Value.kReverse; // Piston keeps the hatcher downwards 
	    protected final DoubleSolenoid flipper;

        public Flipper(DoubleSolenoid flipper) {
		super("FloorIO Flipper");
		this.flipper = flipper;
            
        }
        
        public boolean isUp() {
			return this.flipper.get() == UP;
		}

		public void set(boolean up) {
			if (up) {
				this.flipper.set(UP);
			} else {
				this.flipper.set(DOWN);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new IndexerVelcroDown());
		}       
	}
}
