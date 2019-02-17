package org.usfirst.frc4904.robot.autonly;


import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.RunIf;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class FloorTapeAutoAlign extends CommandGroup {
	public double X = 0;
	public double Y = 1;
	public double TURN = 0;
	public double TIMEOUT = 0;

	public FloorTapeAutoAlign() {
		super("FloorTapeAutoAlign");
		addSequential(new DriveUntilTape());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, RobotMap.UpdateableData.getBetaFloor.getAsDouble(), RobotMap.Component.navx,
		RobotMap.Component.chassisTurnMC));
	}
	public class DriveUntilTape extends ChassisConstant {
		public DriveUntilTape() {
			super(RobotMap.Component.chassis, X, Y, TURN, TIMEOUT);
		}

		protected boolean isFinished() {
			return RobotMap.UpdateableData.getIsFloorTapeVisible.getAsDouble() == 1;
		}
	}
}