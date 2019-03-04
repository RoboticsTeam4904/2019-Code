package org.usfirst.frc4904.robot.autonly;


import java.lang.Math;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import org.usfirst.frc4904.robot.autonly.UpdateableData;

/*
** The robot will drive forwards until it can see the white tape.
** Once the robot can see the white tape, it will stop and turn parallel to it.
*/

public class FloorTapeAutoAlign extends CommandGroup {
	public double X = 0;
	public double Y = 1;
	public double TURN = 0;
	public double TIMEOUT = 0;

	public FloorTapeAutoAlign() {
		super("FloorTapeAutoAlign");
		addSequential(new DriveUntilTape());
		addSequential(UpdateableData.update());
		addSequential(new ChassisTurn(RobotMap.Component.chassis, UpdateableData.getBetaFloor.getAsDouble(), RobotMap.Component.navx,
		RobotMap.Component.chassisTurnMC));
	}
	public class DriveUntilTape extends ChassisConstant {
		public DriveUntilTape() {
			super(RobotMap.Component.chassis, X, Y, TURN, TIMEOUT);
		}

		protected boolean isFinished() {
			return UpdateableData.getIsFloorTapeVisible.getAsBoolean();
		}
	}
}