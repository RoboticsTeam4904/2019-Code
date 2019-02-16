package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;;

public class SolenoidRelease extends SolenoidSet {
	public SolenoidRelease(String name, SolenoidSubsystem system) {
		super(name, system, SolenoidState.RETRACT);
	}

	public SolenoidRelease(SolenoidSubsystem system) {
		this("SolenoidExtend", system);
	}
}