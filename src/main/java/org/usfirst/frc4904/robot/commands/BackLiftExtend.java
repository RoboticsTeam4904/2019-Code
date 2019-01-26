package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Climber.BackLift;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class BackLiftExtend extends BackLiftSet {
	public BackLiftExtend() {
		super(true);
		new WaitCommand(1);
	}
}