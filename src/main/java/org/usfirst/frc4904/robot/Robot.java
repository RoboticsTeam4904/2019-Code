/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4904.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4904.robot.commands.NeutralElevator;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.SingleOp;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		RobotMap.Input.elevatorSwitchBottom.whenPressed(new NeutralElevator());
		RobotMap.Input.elevatorSwitchTop.whenPressed(new NeutralElevator());

		RobotMap.Input.elevatorSwitchBottom.whenPressed(new SingleOp(() -> {
			RobotMap.Component.elevatorEncoder.reset();
		}));
		RobotMap.Input.elevatorSwitchTop.whenPressed(new SingleOp(() -> {
			RobotMap.Component.leftElevatorMotor.setSelectedSensorPosition((int) FourBarElevator.MAX_HEIGHT, 0, 0); // TODO:
																													// CustomEncoder
																													// should
																													// have
																													// a
																													// resetviaOffset
																													// method
		}));
		SmartDashboard.putNumber("ElevatorPID/P", RobotMap.Component.elevatorPID.getP());
		SmartDashboard.putNumber("ElevatorPID/I", RobotMap.Component.elevatorPID.getI());
		SmartDashboard.putNumber("ElevatorPID/D", RobotMap.Component.elevatorPID.getD());
		SmartDashboard.putNumber("ElevatorPID/F", RobotMap.Component.elevatorPID.getF());

	}

	@Override
	public void teleopInitialize() {
	}

	@Override
	public void teleopExecute() {
	}

	@Override
	public void autonomousInitialize() {
	}

	@Override
	public void autonomousExecute() {
	}

	@Override
	public void disabledInitialize() {
	}

	@Override
	public void disabledExecute() {
	}

	@Override
	public void testInitialize() {
	}

	@Override
	public void testExecute() {
	}

	@Override
	public void alwaysExecute() {
		LogKitten.wtf(RobotMap.Component.elevatorEncoder.getDistance());
		SmartDashboard.putNumber("ElevatorPID/e", RobotMap.Component.elevatorPID.getError());
		SmartDashboard.putNumber("ElevatorPID/x", RobotMap.Component.elevatorPID.getSensorValue());
		RobotMap.Component.elevatorPID.setPIDF(SmartDashboard.getNumber("ElevatorPID/P", 0.0),
				SmartDashboard.getNumber("ElevatorPID/I", 0.0), SmartDashboard.getNumber("ElevatorPID/D", 0.0),
				SmartDashboard.getNumber("ElevatorPID/F", 0.0));
		putSBSubsystemSummary();
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
	}
}
