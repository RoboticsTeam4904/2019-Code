package org.usfirst.frc4904.robot.autonly;

import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import java.util.function.DoubleSupplier;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.RunIf;

public class BoringAuton extends CommandGroup {

	public BoringAuton(DoubleSupplier betaSupplier, DoubleSupplier xSupplier, DoubleSupplier ySupplier) {
		super("BoringAuton");
		double beta = betaSupplier.getAsDouble();
		double x = xSupplier.getAsDouble();
		double y = ySupplier.getAsDouble();
		
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, 90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC),
			() -> {return x >= 0;}
		));
		addSequential(new RunIf(
			new ChassisMoveDistance(RobotMap.Component.chassis, x, RobotMap.Component.drivePID),
			() -> {return x >= 0;}
		));
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, -90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC),
			() -> {return x >= 0;}
		));
		addSequential(new RunIf(
			new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID),
			() -> {return x >= 0;}
		));
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, -90 + beta, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC),
			() -> {return x < 0;}
		));
		addSequential(new RunIf(
			new ChassisMoveDistance(RobotMap.Component.chassis, -x, RobotMap.Component.drivePID),
			() -> {return x < 0;}
		));
		addSequential(new RunIf(
			new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, null, RobotMap.Component.chassisTurnMC),
			() -> {return x < 0;}
		));
		addSequential(new RunIf(
			new ChassisMoveDistance(RobotMap.Component.chassis, y, RobotMap.Component.drivePID),
			() -> {return x < 0;}
		));
		}
	}