package org.usfirst.frc4904.robot.commands;


import java.awt.Color;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.custom.sensors.ColorSensor;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;

/**
 *
 */
public class FollowLine extends CommandGroup {
    private final double TURN_RATE = -1;
    private final double TURN_SPEED = -1; 
    private final double STRAIGHT_SPEED = -1;
    private final Color THRESH = new Color(-1, -1, -1);
    private ColorSensor leftSensor;
    private ColorSensor rightSensor;
    private final double duration;

    public FollowLine(ColorSensor left, ColorSensor right, double duration) {
        requires(RobotMap.Component.chassis);
        leftSensor = left;
        rightSensor = right;
        this.duration = duration;
    }

    private boolean thresh(Color c) {
        return c.getRed() >= THRESH.getRed() && c.getGreen() >= THRESH.getGreen() && c.getBlue() >= THRESH.getBlue();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if (thresh(leftSensor.getColor()) && thresh(rightSensor.getColor())) {
            // move forward normal
            new ChassisConstant(RobotMap.Component.chassis, 0, STRAIGHT_SPEED, 0, this.duration);
        }
        else if (thresh(leftSensor.getColor()) && !thresh(rightSensor.getColor())) {
            // turn left
            new ChassisConstant(RobotMap.Component.chassis, 0, TURN_SPEED, -TURN_RATE, this.duration);
        }
        else if (!thresh(leftSensor.getColor()) && thresh(rightSensor.getColor())) {
            // turn right
            new ChassisConstant(RobotMap.Component.chassis, 0, TURN_SPEED, TURN_RATE, this.duration);
        }
        else {
            // lost
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}