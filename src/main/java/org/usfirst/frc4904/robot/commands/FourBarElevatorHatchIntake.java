package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FourBarElevator.State;

public class FourBarElevatorHatchIntake extends FourBarElevatorSet {
    public FourBarElevatorHatchIntake() {
        super("FourBarHatchIntake", State.HATCH_INTAKE);
    }
}