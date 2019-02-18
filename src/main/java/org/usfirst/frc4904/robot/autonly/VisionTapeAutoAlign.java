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

/*
** If the current path of robot will intersect the tape in a specific area, then it will drive forwards.
** Otherwise, it will turn to be facing that area then drive forwards.
** After driving forwards, the robot will turn to be facing the hatch.
** The robot will then drive forwards to the hatch.
*/

public class VisionTapeAutoAlign extends CommandGroup {
	private final DoubleSupplier getNewY = () -> RobotMap.UpdateableData.y - RobotMap.UpdateableData.x / Math.tan(RobotMap.UpdateableData.betaRF);

	private final DoubleSupplier firstTurn = () -> Math.atan2(Math.max(RobotMap.UpdateableData.y / 2, AutonConfig.NO_CLOSER), RobotMap.UpdateableData.x);

	private final DoubleSupplier firstDrive = () -> Math.abs(RobotMap.UpdateableData.x / Math.sin(RobotMap.UpdateableData.betaRF));

	public VisionTapeAutoAlign() {
		super("VisionTapeAutoAlign");
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, firstTurn, RobotMap.Component.navx,
				RobotMap.Component.chassisTurnMC),
			() -> getNewY.getAsDouble() <= AutonConfig.NO_CLOSER || getNewY.getAsDouble() >= RobotMap.UpdateableData.getY.getAsDouble()
		));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, firstDrive, RobotMap.Component.drivePID));
		addSequential(new ChassisTurn(RobotMap.Component.chassis, RobotMap.UpdateableData.getBetaRF, RobotMap.Component.navx,
			RobotMap.Component.chassisTurnMC));
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, RobotMap.UpdateableData.getBetaRF, RobotMap.Component.navx,
		RobotMap.Component.chassisTurnMC));
		addSequential(new RobotMap.UpdateableData.Update());
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, RobotMap.UpdateableData.getY, RobotMap.Component.drivePID));
	}
}