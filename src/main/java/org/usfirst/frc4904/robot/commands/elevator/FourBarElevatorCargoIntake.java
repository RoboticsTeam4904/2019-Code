package org.usfirst.frc4904.robot.commands.elevator;

import org.usfirst.frc4904.robot.subsystems.FourBarElevator.State;

public class FourBarElevatorCargoIntake extends FourBarElevatorSet {
    public FourBarElevatorCargoIntake() {
        super("FourBarElevatorCargoIntake", State.CARGO_INTAKE);
    }
}