package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClawsUp extends CommandGroup {
	public ClawsUp() {
		addParallel(new SolenoidRetract("Claws Up", RobotMap.Component.manipulator.claws));
		addParallel(new RollerStop());
	}
}