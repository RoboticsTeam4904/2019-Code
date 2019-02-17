package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.FourBarElevator.FourBarState;

public class FourBarHatchIntake extends FourBarSet {
    public FourBarHatchIntake() {
        super("FourBarHatchIntake", FourBarState.HATCH_INTAKE);
    }
}