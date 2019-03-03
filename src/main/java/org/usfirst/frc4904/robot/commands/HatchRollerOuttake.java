package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.FloorIO;

public class HatchRollerOuttake extends HatchRollerSet {
	public HatchRollerOuttake() {
		super("HatchRollerOuttake", FloorIO.HATCH_OUTTAKE_SPEED);
	}
}