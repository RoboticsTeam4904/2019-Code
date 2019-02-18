package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NotSplines extends CommandGroup {
    public NotSplines() {
		super("NotSplines");
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, RobotMap.UpdateableData.getTheta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.UpdateableData.getDistance, RobotMap.Component.drivePID));
    }
}