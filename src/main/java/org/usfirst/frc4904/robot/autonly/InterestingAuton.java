package org.usfirst.frc4904.robot.autonly;

import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class InterestingAuton extends CommandGroup {

	public InterestingAuton(double beta, double x, double y) {
		super("InterestingAuton");
		double firstDrive = x/Math.sin(beta);
		double newY = y - x/Math.tan(beta);
		if (x >= 0) {
			if (newY <= 0 || newY >= y) {
				addSequential(new ChassisTurn(RobotMap.Component.chassis, 90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, x, RobotMap.Component.drivePID));
				addSequential(new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID));
			}
			else {
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, firstDrive, RobotMap.Component.drivePID));
				addSequential(new ChassisTurn(RobotMap.Component.chassis, -beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, newY, RobotMap.Component.drivePID));
			}
		}
		else {
			addSequential(new ChassisTurn(RobotMap.Component.chassis, -90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -x, RobotMap.Component.drivePID));
			addSequential(new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID));
		}
	}
}