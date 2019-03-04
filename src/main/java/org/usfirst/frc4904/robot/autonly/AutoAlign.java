package org.usfirst.frc4904.robot.autonly;

import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class AutoAlign extends CommandGroup {

	public AutoAlign(DoubleSupplier betaSupplier, DoubleSupplier xSupplier, DoubleSupplier ySupplier) {
		super("AutoAlign");
		addSequential(new RunIfElse(
			new AutoAlignPosX(betaSupplier, xSupplier, ySupplier), //the left of the robot is towards the positive x direction
			new AutoAlignNegX(betaSupplier, xSupplier, ySupplier),
			() -> xSupplier.getAsDouble() >= 0
		));
		addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, () -> ySupplier.getAsDouble(), RobotMap.Component.drivePID));
	}
	public class AutoAlignPosX extends CommandGroup {
		public AutoAlignPosX(DoubleSupplier betaSupplier, DoubleSupplier xSupplier, DoubleSupplier ySupplier) {
			super("AutoAlignPosX"); //chassisturn and beta are positive to the right
			addSequential(new ChassisTurn(RobotMap.Component.chassis, () -> 90 + betaSupplier.getAsDouble(), RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, () -> xSupplier.getAsDouble(), RobotMap.Component.drivePID));
			addSequential(new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
		}
	}
	public class AutoAlignNegX extends CommandGroup {
		public AutoAlignNegX(DoubleSupplier betaSupplier, DoubleSupplier xSupplier, DoubleSupplier ySupplier) {
			super("AutoAlignNegX");
			addSequential(new ChassisTurn(RobotMap.Component.chassis, () -> -90 + betaSupplier.getAsDouble(), RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
			addSequential(new ChassisMoveDistance(RobotMap.Component.chassis, () -> -xSupplier.getAsDouble(), RobotMap.Component.drivePID));
			addSequential(new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC));
		}
	}
}