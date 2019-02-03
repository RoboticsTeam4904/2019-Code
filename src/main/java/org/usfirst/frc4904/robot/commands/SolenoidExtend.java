package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.robot.subsystems.SolenoidSubsystem.SolenoidState;

public class SolenoidExtend extends SolenoidSet {
    public SolenoidExtend(String name, SolenoidSubsystem system) {
        super(name, system, SolenoidState.EXTENDED);
    }

    public SolenoidExtend(SolenoidSubsystem system) {
        this("SolenoidExtend", system);
    }
}