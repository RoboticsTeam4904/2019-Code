package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PickupSolenoidRoutine extends CommandGroup {
    private static final double WAIT_TIME = 0.5;

	public PickupSolenoidRoutine() { // TODO: Update this routine for new requirements/routine developments.
        super("PickupSolenoidRoutine");
        addSequential(new PickupSolenoidClasp());
        addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new PickupSolenoidRelease());
	}
}