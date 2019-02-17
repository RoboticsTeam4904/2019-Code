package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FourBarElevator.State;

public class FourBarCargoIntake extends FourBarSet {
    public FourBarCargoIntake() {
        super("FourBarCargoIntake", State.CARGO_INTAKE);
    }
}