package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HatcherSpinMotor extends MotorConstant {
    public HatcherSpinMotor (double speed) {
        super(RobotMap.Component.Floorio.hatcherRollerIntake, speed);
    }
}