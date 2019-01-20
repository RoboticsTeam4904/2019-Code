package org.usfirst.frc4904.robot.subsystems;

//import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.commands.VelcroPlateDefault;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.standard.commands.Noop;

//import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
//import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

/*
 * This is deprecated after its merger with Floorio (#5).
 * 
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

 //TODO: Create a command using MotorPositionConstant to set the motor to a position.

public class VelcroPlate extends Subsystem {
	public final DoubleSolenoid placeSolenoid;
	public final DoubleSolenoid pickupSolenoid;
	public static final DoubleSolenoid.Value PICKUP_CLASPED = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value PICKUP_RELEASED = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value PLACE_CLASPED = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value PLACE_RELEASED = DoubleSolenoid.Value.kReverse;


	public VelcroPlate(DoubleSolenoid pickupSolenoid, DoubleSolenoid placeSolenoid) {
		this.placeSolenoid = pickupSolenoid;
		this.pickupSolenoid = placeSolenoid;
	}

	public void setPlaceSolenoid(boolean clasped) {
		if(getPickupSolenoid() && clasped) return; // Fail if the other solenoid is already clasped.
		if(clasped){
			this.placeSolenoid.set(PLACE_CLASPED);
		} else {
			this.placeSolenoid.set(PLACE_RELEASED);
		}
		return;
	}

	public void setPickupSolenoid(boolean clasped) {
		if(getPlaceSolenoid() && clasped) return; // Fail if the other solenoid is already clasped.
		if(clasped){
			this.pickupSolenoid.set(PICKUP_CLASPED);
		} else {
			this.pickupSolenoid.set(PICKUP_RELEASED);
		}
		return;
	}

	public boolean getPickupSolenoid() {
		return this.pickupSolenoid.get() == PICKUP_CLASPED;
	}

	public boolean getPlaceSolenoid() {
		return this.placeSolenoid.get() == PLACE_CLASPED;
	}

	public void initDefaultCommand() {
        setDefaultCommand(new VelcroPlateDefault());
	}
}