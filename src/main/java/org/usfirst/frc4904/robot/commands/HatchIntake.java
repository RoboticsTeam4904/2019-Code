package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchIntake extends CommandGroup {
	public HatchIntake() {
		addSequential(new ManipulatorGrabberOut());
		addSequential(new ManipulatorGroundOut());
		addSequential(new ElevatorUp());
		addSequential(new ManipulatorGroundIn());
		addSequential(new ElevatorDown());
	}
}