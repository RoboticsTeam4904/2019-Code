package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HatcherSpin extends MotorConstant {
    public HatcherSpin (double speed) {
        super(RobotMap.Component.Floorio.hatcherRollerIntake, speed);
    }
}

