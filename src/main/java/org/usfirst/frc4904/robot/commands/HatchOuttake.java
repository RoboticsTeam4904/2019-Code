package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class HatchOuttake extends CommandGroup {
	public static final double WAIT_TIME = 0.5;
	public HatchOuttake() {
		addParallel(new HatchOuttakeExtend());
		addSequential(new WaitCommand(WAIT_TIME));	
		addSequential(new HatchOuttakeRetract());

	}
}