package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LevelOneHatch extends CommandGroup {
	public static double WAIT_TIME_BEFORE_HATCH_OUTTAKE = 0.5; // seconds

	public LevelOneHatch() {
		addParallel(new SolenoidRetract("FourBarDown", RobotMap.Component.fourBar.lever));
		addParallel(new WristUp());
		addParallel(new ClawsUp());
		addSequential(new WaitCommand("Wait for hatch outtake", WAIT_TIME_BEFORE_HATCH_OUTTAKE));
		addSequential(new SolenoidExtend("Hatch out", RobotMap.Component.manipulator.hatchExtender));
	}
}