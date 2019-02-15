package org.usfirst.frc4904.robot.autonly;

import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.RunIf;

public class NetworkTablesAuton extends CommandGroup {

	public NetworkTablesAuton() {
		super("NetworkTablesAuton");
		double beta = RobotMap.NetworkTables.Sensors.beta.getDouble(-1.0);
		double x = RobotMap.NetworkTables.Sensors.x.getDouble(-1.0);
		double y = RobotMap.NetworkTables.Sensors.y.getDouble(-1.0);
		double firstTurn = Math.atan2(y/2, x);
		double newY = y - x/Math.tan(beta);
		double firstDrive = x/Math.sin(90-beta);
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, firstTurn, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC),
			() -> {return newY <= 0;} //TODO: change 0 to robotwidth/2
		));
		beta = RobotMap.NetworkTables.Sensors.beta.getDouble(-1.0);
		x = RobotMap.NetworkTables.Sensors.x.getDouble(-1.0);
		y = RobotMap.NetworkTables.Sensors.y.getDouble(-1.0);
		if (x >= 0) {
			if (newY <= 0 || newY >= y) {
				addSequential(new ChassisTurn(RobotMap.Component.chassis, firstTurn, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, firstDrive, RobotMap.Component.drivePID));
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
			if (newY <= 0 || newY >= y) {
				addSequential(new ChassisTurn(RobotMap.Component.chassis, -90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, -x, RobotMap.Component.drivePID));
				addSequential(new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID));
			}
			else {
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, firstDrive, RobotMap.Component.drivePID));
				addSequential(new ChassisTurn(RobotMap.Component.chassis, beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
				addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, newY, RobotMap.Component.drivePID));
			}
		}
	}
}