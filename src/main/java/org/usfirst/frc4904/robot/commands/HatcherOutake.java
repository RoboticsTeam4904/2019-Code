package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FloorIO;


public class HatcherOutake extends HatcherSpin {
    public HatcherOutake () {
        super(FloorIO.OUTTAKE_SPEED);
    }
}