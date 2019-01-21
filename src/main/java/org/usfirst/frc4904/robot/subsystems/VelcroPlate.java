package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.VelcroPlateDefault;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

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
		if(clasped){
			this.placeSolenoid.set(PLACE_CLASPED);
		} else {
			this.placeSolenoid.set(PLACE_RELEASED);
		}
	}

	public void setPickupSolenoid(boolean clasped) {
		if(clasped){
			this.pickupSolenoid.set(PICKUP_CLASPED);
		} else {
			this.pickupSolenoid.set(PICKUP_RELEASED);
		}
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