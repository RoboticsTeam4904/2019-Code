package org.usfirst.frc4904.robot.autonly;


import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.RunIf;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


public class NetworkTablesAuton extends CommandGroup {
	public static double fallbackAngle = -1;

	public NetworkTablesAuton() {
		super("NetworkTablesAuton");
		double driveTolerance = RobotMap.Metrics.Robot.ROBOT_WIDTH / 2;
		Data getData = new Data();
		addParallel(getData);
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, getData.firstTurnIfBad(), RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {return getData.getNewY().getAsDouble() >= driveTolerance;}
		));
		addSequential(new RunIfElse(
			new ChassisMoveDistance(RobotMap.Component.chassis, getData.firstDriveIfBad(), RobotMap.Component.drivePID),
			new ChassisMoveDistance(RobotMap.Component.chassis, getData.firstDriveIfGood(), RobotMap.Component.drivePID),
			() -> {return getData.getNewY().getAsDouble() >= driveTolerance;}
		));
		addSequential(new ChassisTurn(RobotMap.Component.chassis, getData.getBeta(), RobotMap.Component.navx, RobotMap.Component.chassisTurnMC));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, getData.getY(), RobotMap.Component.drivePID));
	}
	public class Data extends Command {
		private double beta;
		private double x;
		private double y;
		private double newY;
		private double firstDriveIfBad;
		private double firstDriveIfGood;

		public void execute() {
			beta = RobotMap.NetworkTables.Sensors.beta.getDouble(fallbackAngle);
			x = RobotMap.NetworkTables.Sensors.x.getDouble(-1.0);
			y = RobotMap.NetworkTables.Sensors.y.getDouble(-1.0);
		}

		private DoubleSupplier getBeta() {
			return () -> beta;
		}

		private DoubleSupplier getX() {
			return () -> x;
		}

		private DoubleSupplier getY() {
			return () -> y;
		}

		private DoubleSupplier getNewY() {
			if (x >= 0) {
				newY = y - x * Math.tan(beta);
			}
			else {
				newY = y - x * Math.tan(-beta);
			}
			return () -> newY;
		}

		private DoubleSupplier firstTurnIfBad() {
			return () -> Math.atan2(y / 2, x);
		}

		private DoubleSupplier firstDriveIfBad() {
			if (x >= 0) {
				firstDriveIfBad = x / Math.sin(Math.PI / 2 - beta);
			}
			else {
				firstDriveIfBad = x / Math.sin(Math.PI / 2 + beta);
			}
			return () -> firstDriveIfBad;
		}

		private DoubleSupplier firstDriveIfGood() {
			if (x >= 0) {
				firstDriveIfGood = x / Math.sin(beta);
			}
			else {
				firstDriveIfGood = x / Math.sin(-beta);
			}
			return () -> firstDriveIfGood;
		}

		public boolean isFinished() {
			return false;
		}
	}
}