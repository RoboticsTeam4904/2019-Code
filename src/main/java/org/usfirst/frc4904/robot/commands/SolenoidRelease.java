package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.robot.subsystems.SolenoidSubsystem.SolenoidState;

public class SolenoidRelease extends SolenoidSet {
    public SolenoidRelease(String name, SolenoidSubsystem system) {
        super(name, system, SolenoidState.RELEASED);
    }

    public SolenoidRelease(SolenoidSubsystem system) {
        this("SolenoidExtend", system);
    }
}