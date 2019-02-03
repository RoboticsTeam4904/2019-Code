package org.usfirst.frc4904.robot.commands;

import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NotSplines extends CommandGroup {
    public static class Values{
        public static final double distance = 1.0;
        public static final double angle = 45.0;
        public static final double distance_x = distance*Math.sin(angle);
        public static final double distance_y = distance*Math.cos(angle);
    }
    public NotSplines() {
        super("NotSplines");
		addSequential(new ChassisTurn(RobotMap.Component.chassis, Values.angle, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
		addParallel(new ChassisMoveDistance(RobotMap.Component.chassis, Values.distance, RobotMap.Component.drivePID));
    }
}