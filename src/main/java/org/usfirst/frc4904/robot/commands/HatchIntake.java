package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchIntake extends CommandGroup {
	public HatchIntake() {
		addSequential(new SolenoidExtend("ManipulatorGrabberOut", RobotMap.Component.manipulator.grabber));
		addSequential(new SolenoidExtend("ManipulatorGroundOut", RobotMap.Component.manipulator.ground));
		addSequential(new RunFor(new MotorConstant("ElevatorUp", RobotMap.Component.fourBar.elevator, FourBarElevator.UP_SPEED),FourBarElevator.UP_TIME));
		addSequential(new SolenoidRetract("ManipulatorGroundIn", RobotMap.Component.manipulator.ground));
		addSequential(new RunFor(new MotorConstant("ElevatorDown", RobotMap.Component.fourBar.elevator, FourBarElevator.DOWN_SPEED),FourBarElevator.DOWN_TIME));
	}
}