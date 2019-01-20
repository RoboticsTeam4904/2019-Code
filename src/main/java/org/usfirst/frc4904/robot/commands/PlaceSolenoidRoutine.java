package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;

public class PlaceSolenoidRoutine extends CommandGroup {
    private static final double MOTOR_MOVE_X = 0.0;
    private static final double MOTOR_MOVE_Y = -0.5;
    private static final double MOTOR_HALT_X = 0.0;
    private static final double MOTOR_HALT_Y = 0.0;
    private static final double MOTOR_TURN = 0.0;

	public PlaceSolenoidRoutine() {
        super("PlaceSolenoidRoutine");
        //addParallel(new ChassisConstant(RobotMap.Component.chassis, MOTOR_MOVE_X, MOTOR_MOVE_Y, MOTOR_TURN, 0.0)); // See PR #11 comments
        addSequential(new PlaceSolenoidClasp());
        //addParallel(new ChassisConstant(RobotMap.Component.chassis, MOTOR_HALT_X, MOTOR_HALT_Y, MOTOR_TURN, 0.0)); // See PR #11 comments
        addSequential(new PlaceSolenoidRelease());
	}
}