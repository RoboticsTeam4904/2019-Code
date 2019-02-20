package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

/**
 * Pushes out the Velcro plate
 */
public class VelcroPistonExtend extends SolenoidExtend {
	public VelcroPistonExtend() {
		super("VelcroPistonExtend", RobotMap.Component.floorio.velcroPiston);
	}
}