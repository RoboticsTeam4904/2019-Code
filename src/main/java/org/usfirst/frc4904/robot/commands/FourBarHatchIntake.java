package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FourBarElevator.State;

public class FourBarHatchIntake extends FourBarSet {
    public FourBarHatchIntake() {
        super("FourBarHatchIntake", State.HATCH_INTAKE);
    }
}