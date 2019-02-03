package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FloorIO;


public class HatchIntake extends HatchSpin {
    public HatchIntake () {
        super(FloorIO.INTAKE_SPEED);
    }
}