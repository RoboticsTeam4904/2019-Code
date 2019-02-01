package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FloorIO;


public class HatcherIntake extends HatcherSpin {
    public HatcherIntake () {
        super(FloorIO.INTAKE_SPEED);
    }
}