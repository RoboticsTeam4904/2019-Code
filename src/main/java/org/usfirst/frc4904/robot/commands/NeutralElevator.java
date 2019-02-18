package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class NeutralElevator extends Command {
    public NeutralElevator() {
        super("NeutralElevator", RobotMap.Component.fourBar.elevator);
    }

    public void execute() {
        RobotMap.Component.leftElevatorMotor.neutralOutput();
        RobotMap.Component.rightElevatorMotor.neutralOutput();
    }

    public boolean isFinished() {
        return false;
    }
}