package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidSet;
import org.usfirst.frc4904.robot.commands.PickupSolenoidSet;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;

public class VelcroPlateDefault extends CommandGroup {
    private static final double MOTOR_HALT_X = 0.0;
    private static final double MOTOR_HALT_Y = 0.0;
    private static final double MOTOR_TURN = 0.0;

	public VelcroPlateDefault() {
        super("VelcroPlateDefault");
        addParallel(new ChassisConstant(RobotMap.Component.chassis, MOTOR_HALT_X, MOTOR_HALT_Y, MOTOR_TURN, 0.0));
        addParallel(new PlaceSolenoidSet(false));
        addParallel(new PickupSolenoidSet(false));
	}
}