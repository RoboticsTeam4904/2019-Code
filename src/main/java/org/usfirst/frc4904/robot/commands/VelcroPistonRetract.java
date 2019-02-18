package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

/**
 * Pulls in the velcro plate
 */
public class VelcroPistonRetract extends SolenoidRetract {
	public VelcroPistonRetract() {
		super("PickupSolenoidDown", RobotMap.Component.floorio.velcroPiston);
	}
}