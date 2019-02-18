package org.usfirst.frc4904.robot.autonly;


import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.RunIf;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import org.usfirst.frc4904.robot.autonly.AutonConfig;
import org.usfirst.frc4904.robot.autonly.UpdateableData;

/*
** If the current path of robot will intersect the tape in a specific area, then it will drive forwards.
** Otherwise, it will turn to be facing that area then drive forwards.
** After driving forwards, the robot will turn to be facing the hatch.
** The robot will then drive forwards to the hatch.
*/

public class VisionTapeAutoAlign extends CommandGroup {
	private final DoubleSupplier getNewY = () -> UpdateableData.y - UpdateableData.x / Math.tan(UpdateableData.betaRF);

	private final DoubleSupplier firstTurn = () -> Math.atan2(Math.max(UpdateableData.y / 2, AutonConfig.NO_CLOSER), UpdateableData.x);

	private final DoubleSupplier firstDrive = () -> Math.abs(UpdateableData.x / Math.sin(UpdateableData.betaRF));

	public VisionTapeAutoAlign() {
		super("VisionTapeAutoAlign");
		addSequential(UpdateableData.update());
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, firstTurn, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> getNewY.getAsDouble() <= AutonConfig.NO_CLOSER || getNewY.getAsDouble() >= UpdateableData.getY.getAsDouble()
		));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, firstDrive, RobotMap.Component.drivePID));
		addSequential(new ChassisTurn(RobotMap.Component.chassis, UpdateableData.getBetaRF, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(UpdateableData.update());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, UpdateableData.getBetaRF, RobotMap.Component.navx,
		RobotMap.Component.chassisTurnMC));
		addSequential(UpdateableData.update());
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, UpdateableData.getY, RobotMap.Component.drivePID));
	}
}