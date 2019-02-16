package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

/**
 * This command sets the state of the associated group to extended.
 */
public class VelcroPistonExtend extends SolenoidExtend {
	public VelcroPistonExtend() {
		super("VelcroPistonExtend", RobotMap.Component.floorio.velcroPiston);
	}
}