package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FourBarLinkage.FourBarState;

public class FourBarCargoIntake extends FourBarSet {
    public FourBarCargoIntake() {
        super("FourBarCargoIntake", FourBarState.CARGO_INTAKE);
    }
}