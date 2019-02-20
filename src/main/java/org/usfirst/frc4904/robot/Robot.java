/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4904.robot.commands.CameraStream;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		CameraStream streamCommand = new CameraStream(2);
		streamCommand.start();
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		RobotMap.Component.leftWheelEncoder.reset();
		RobotMap.Component.rightWheelEncoder.reset();
		SmartDashboard.putNumber("DrivePID/P", RobotMap.Component.drivePID.getP());
		SmartDashboard.putNumber("DrivePID/I", RobotMap.Component.drivePID.getI());
		SmartDashboard.putNumber("DrivePID/D", RobotMap.Component.drivePID.getD());
		SmartDashboard.putNumber("DrivePID/F", RobotMap.Component.drivePID.getF());
		SmartDashboard.putNumber("TurnPID/P", RobotMap.Component.chassisTurnPID.getP());
		SmartDashboard.putNumber("TurnPID/I", RobotMap.Component.chassisTurnPID.getI());
		SmartDashboard.putNumber("TurnPID/D", RobotMap.Component.chassisTurnPID.getD());
		SmartDashboard.putNumber("TurnPID/F", RobotMap.Component.chassisTurnPID.getF());
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {
	}

	@Override
	public void autonomousInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();
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
		SmartDashboard.putNumber("DrivePID/e", RobotMap.Component.drivePID.getError());
		SmartDashboard.putNumber("DrivePID/x", RobotMap.Component.drivePID.getSensorValue());
		SmartDashboard.putNumber("TurnPID/e", RobotMap.Component.chassisTurnPID.getError());
		SmartDashboard.putNumber("TurnPID/x", RobotMap.Component.chassisTurnPID.getSensorValue());
		RobotMap.Component.drivePID.setPIDF(SmartDashboard.getNumber("DrivePID/P", 0.0),
				SmartDashboard.getNumber("DrivePID/I", 0.0), SmartDashboard.getNumber("DrivePID/D", 0.0),
				SmartDashboard.getNumber("DrivePID/F", 0.0));
		RobotMap.Component.chassisTurnPID.setPIDF(SmartDashboard.getNumber("TurnPID/P", 0.0),
				SmartDashboard.getNumber("TurnPID/I", 0.0), SmartDashboard.getNumber("TurnPID/D", 0.0),
				SmartDashboard.getNumber("TurnPID/F", 0.0));
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
