package org.usfirst.frc4904.robot.commands.manipulator;


import org.usfirst.frc4904.robot.subsystems.Manipulator;

public class RollerOut extends RollerSet {
	public RollerOut() {
		super("Roller Out", Manipulator.OUTTAKE_SPEED);
	}
}