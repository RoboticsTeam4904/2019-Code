package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PickupSolenoidRoutine extends CommandGroup {
    private static final double WAIT_TIME = 0.5;

	public PickupSolenoidRoutine() {
        super("PickupSolenoidRoutine");
        addSequential(new PickupSolenoidSet(true));
        addSequential(new WaitCommand(WAIT_TIME)); // Initially was the WaitFor command in PR #224
        addSequential(new PickupSolenoidSet(false));
	}
}