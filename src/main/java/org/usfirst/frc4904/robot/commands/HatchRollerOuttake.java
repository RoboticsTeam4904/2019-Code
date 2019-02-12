package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.FloorIO;

public class HatchRollerOuttake extends HatchSpin {
	public HatchRollerOuttake() {
		super("HatchRollerOuttake", FloorIO.HATCH_OUTTAKE_SPEED);
	}
}