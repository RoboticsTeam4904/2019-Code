package org.usfirst.frc4904.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PlaceSolenoidRoutine extends CommandGroup { // TODO: Update this routine for new requirements.
    public static final double WAIT_TIME = 0.5;

    public PlaceSolenoidRoutine() {
        super("PlaceSolenoidRoutine");
        addParallel(new PlaceSolenoidDown());
        addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new PlaceSolenoidUp());
    }
}