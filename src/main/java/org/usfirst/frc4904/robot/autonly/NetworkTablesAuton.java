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
	public static double driveTolerance = RobotMap.Metrics.Robot.ROBOT_WIDTH / 2;

	public NetworkTablesAuton() {
		super("NetworkTablesAuton");
		Data getData = new Data();
		addParallel(getData);
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, getData.firstTurn, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> {
				return getData.getNewY.getAsDouble() >= driveTolerance;
			}));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, getData.firstDrive, RobotMap.Component.drivePID));
		addSequential(new ChassisTurn(RobotMap.Component.chassis, getData.getBeta, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, getData.getY, RobotMap.Component.drivePID));
	}

	public class Data extends Command {
		private double beta;
		private double x;
		private double y;
		private double newY;

		public void execute() {
			beta = RobotMap.NetworkTables.Sensors.beta.getDouble(fallbackAngle);
			x = RobotMap.NetworkTables.Sensors.x.getDouble(-1.0);
			y = RobotMap.NetworkTables.Sensors.y.getDouble(-1.0);
		}

		private final DoubleSupplier getBeta = () -> beta;

		private final DoubleSupplier getX = () -> x;

		private final DoubleSupplier getY = () -> y;

		private final DoubleSupplier getNewY = () -> {
			if (x >= 0) {
				newY = y - x * Math.tan(beta);
			} else {
				newY = y - x * Math.tan(-beta);
			}
			return y;
		};

		private final DoubleSupplier firstTurn = () -> Math.atan2(y / 2, x);

		private final DoubleSupplier firstDrive = () -> {
			double first;
			if (newY <= driveTolerance || newY >= y) {
				if (x >= 0) {
					first = x / Math.sin(Math.PI / 2 - beta);
				} else {
					first = x / Math.sin(Math.PI / 2 + beta);
				}
			} else {
				if (x >= 0) {
					first = x / Math.sin(beta);
				} else {
					first = x / Math.sin(-beta);
				}
			}
			return first;
		};

		public boolean isFinished() {
			return false;
		}
	}
}