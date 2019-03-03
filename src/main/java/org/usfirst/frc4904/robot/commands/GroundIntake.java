package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GroundIntake extends CommandGroup {
	public GroundIntake() {
		addSequential(new SolenoidExtend("ManipulatorGroundOut", RobotMap.Component.manipulator.ground));
		addSequential(new MotorConstant("ManipulatorRollersIn", RobotMap.Component.manipulator.rollers, Manipulator.INTAKE_SPEED));
		addSequential(new SolenoidRetract("ManipulatorGroundIn", RobotMap.Component.manipulator.ground));
		addSequential(new MotorConstant("ManipulatorRollersStop", RobotMap.Component.manipulator.rollers, 0));
	}
}