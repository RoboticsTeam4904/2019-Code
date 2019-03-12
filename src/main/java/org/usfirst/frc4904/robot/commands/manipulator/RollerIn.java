package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.subsystems.Manipulator;

public class RollerIn extends RollerSet {
	public RollerIn() {
		super("RollerIn", Manipulator.INTAKE_SPEED);
	}
}