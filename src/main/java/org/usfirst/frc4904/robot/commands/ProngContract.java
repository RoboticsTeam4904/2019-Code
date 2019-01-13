package org.usfirst.frc4904.robot.commands;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ProngContract extends MotorConstant{
    public ProngContract(){
        super(RobotMap.Component.prongIOExpander, RobotMap.Component.prongIO.CONTRACTION_SPEED);
    }
}