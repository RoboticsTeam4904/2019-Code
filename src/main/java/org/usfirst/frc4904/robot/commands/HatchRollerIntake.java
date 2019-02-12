package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.FloorIO;

public class HatchRollerIntake extends HatchSpin {
	public HatchRollerIntake() {
		super("HatchRollerIntake", FloorIO.HATCH_INTAKE_SPEED);
	}
}