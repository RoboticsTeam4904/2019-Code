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

public class FloorTapeAutoAlign extends CommandGroup {
	public static double fallbackValue = -1;
	public static double driveTolerance = RobotMap.Metrics.Robot.ROBOT_WIDTH / 2;
	public static double minimumVisionDistance = 18;

	RobotMap.UpdateableData.Update update = new RobotMap.UpdateableData.Update();
	
	private final DoubleSupplier getNewY = () -> RobotMap.UpdateableData.y - RobotMap.UpdateableData.x / Math.tan(RobotMap.UpdateableData.betaRetroreflective);

	private final DoubleSupplier firstTurn = () -> Math.atan2(Math.max(RobotMap.UpdateableData.y / 2, minimumVisionDistance), RobotMap.UpdateableData.x);

	private final DoubleSupplier firstDrive = () -> {
		double first;
		if (RobotMap.UpdateableData.x >= 0) {
			first = RobotMap.UpdateableData.x / Math.sin(RobotMap.UpdateableData.betaRetroreflective);
		} else {
			first = RobotMap.UpdateableData.x / Math.sin(-RobotMap.UpdateableData.betaRetroreflective);
		}
		return first;
	};

	public FloorTapeAutoAlign() {
		super("FloorTapeAutoAlign");
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, firstTurn, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> getNewY.getAsDouble() <= Math.max(driveTolerance,minimumVisionDistance) || getNewY.getAsDouble() >= RobotMap.UpdateableData.y
		));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, firstDrive, RobotMap.Component.drivePID));
		addSequential(new ChassisTurn(RobotMap.Component.chassis, RobotMap.UpdateableData.betaRetroreflective, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, RobotMap.UpdateableData.getBetaRetroreflective, RobotMap.Component.navx,
		RobotMap.Component.chassisTurnMC));
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.UpdateableData.y, RobotMap.Component.drivePID));
	}
}