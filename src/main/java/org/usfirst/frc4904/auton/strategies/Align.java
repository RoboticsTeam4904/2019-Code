package org.usfirst.frc4904.auton.strategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunFor;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Align extends CommandGroup {
    protected static final double PAUSE_BETWEEN_ALIGNMENT_CYCLES = 0.4;
    protected static final int ALIGNMENT_CYCLES = 2;
    protected static final int MAX_CYCLE_TIME_SECONDS = 1;

    public Align() {
        for (int i = 0; i < Align.ALIGNMENT_CYCLES; ++i) {
            addSequential(new WaitCommand(Align.PAUSE_BETWEEN_ALIGNMENT_CYCLES));
            addSequential(new RunFor(new VisionTurn(RobotMap.Component.alignmentCamera), Align.MAX_CYCLE_TIME_SECONDS));
            // TODO: Have multiple "cameras" on CAN/NT and multiple commands that extend this one
            // TODO: Maybe also add some kind of alignment validation with trustable
        }
        addSequential(new KittenCommand("Done aligning", LogKitten.LEVEL_VERBOSE));
    }
}