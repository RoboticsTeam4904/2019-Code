package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.ProngIO;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PusherFireRetract extends CommandGroup {
    public static final double WAIT_TIME = 2;
	public PusherFireRetract() {
		super("PusherFireRetract");
		addParallel(new PusherFire());
		addSequential(new WaitCommand(WAIT_TIME));
		addParallel(new PusherRetract());
	}
}