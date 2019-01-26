package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Climber.BackLift;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class BackLiftExtend extends BackLiftSet {
	public BackLiftExtend() {
		super(true);
		final double WAIT_TIME = 1; //Change constant as needed
		new WaitCommand(WAIT_TIME);
	}
}