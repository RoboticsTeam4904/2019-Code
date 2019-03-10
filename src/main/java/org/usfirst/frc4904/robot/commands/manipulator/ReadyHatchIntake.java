package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Gets robot ready to intake hatch
 */
public class ReadyHatchIntake extends CommandGroup {
	public ReadyHatchIntake() {
		super("HatchIntake");
		requires(RobotMap.Component.manipulator.arm);
		requires(RobotMap.Component.manipulator.claws);
		requires(RobotMap.Component.manipulator.grabber);
		requires(RobotMap.Component.manipulator.hatchExtender);
		requires(RobotMap.Component.manipulator.roller);
		addParallel(new ManipulatorArmUp());
		addParallel(new ManipulatorClawsUp());
		addParallel(new HatchExtenderIn());
	}
}