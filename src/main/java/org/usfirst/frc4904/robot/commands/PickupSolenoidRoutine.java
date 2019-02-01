package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc4904.robot.commands.PickupSolenoidDown;
import org.usfirst.frc4904.robot.commands.PickupSolenoidUp;

public class PickupSolenoidRoutine extends CommandGroup {
    private static final double WAIT_TIME = 0.5;

	public PickupSolenoidRoutine() { // TODO: Update this routine for new requirements/routine developments.
        super("PickupSolenoidRoutine");
        addSequential(new PickupSolenoidDown());
        addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new PickupSolenoidUp());
	}
}