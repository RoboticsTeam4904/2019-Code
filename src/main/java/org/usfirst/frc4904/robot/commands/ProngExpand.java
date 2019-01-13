package org.usfirst.frc4904.robot.commands;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class ProngExpand extends MotorConstant{
    public ProngExpand(){
        super(RobotMap.Component.prongIOExpander, RobotMap.Component.prongIO.EXPANSION_SPEED);
    }
}