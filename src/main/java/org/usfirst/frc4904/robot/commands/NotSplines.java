package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.autonly.UpdateableData;

public class NotSplines extends CommandGroup {
    public NotSplines() {
		super("NotSplines");
		addSequential(UpdateableData.update());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, UpdateableData.getTheta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
		addSequential(UpdateableData.update());
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, UpdateableData.getDistance, RobotMap.Component.drivePID));
    }
}