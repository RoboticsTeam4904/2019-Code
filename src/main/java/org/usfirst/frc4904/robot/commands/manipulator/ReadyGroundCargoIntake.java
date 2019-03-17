package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReadyGroundCargoIntake extends CommandGroup {
	public ReadyGroundCargoIntake() {
		addParallel(new SolenoidRetract("FourBarDown", RobotMap.Component.fourBar.lever));
		addParallel(new HatchExtenderIn());
		addParallel(new WristDown());
		addParallel(new ClawsDown());
	}
}