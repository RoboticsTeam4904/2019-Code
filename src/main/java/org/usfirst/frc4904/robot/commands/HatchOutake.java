package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FloorIO;


public class HatchOutake extends HatchSpin {
    public HatchOutake () {
        super(FloorIO.HATCH_OUTTAKE_SPEED);
    }
}