package org.usfirst.frc4904.robot.autonly;

import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class BoringAuton extends CommandGroup {

	public BoringAuton(double beta, double x, double y) {
		super("BoringAuton");
		if (x >= 0) {
			addSequential(new ChassisTurn(RobotMap.Component.chassis, 90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, x, RobotMap.Component.drivePID));
			addSequential(new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID));
		}
		else {
			addSequential(new ChassisTurn(RobotMap.Component.chassis, -90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -x, RobotMap.Component.drivePID));
			addSequential(new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID));
		}
	}
}