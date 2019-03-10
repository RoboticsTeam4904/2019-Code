/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4904.robot.commands.elevator.NeutralElevator;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.robot.commands.CameraStream;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		CameraStream streamCommand = new CameraStream(2);
		streamCommand.start();
		// RobotMap.Component.leftWheelEncoder.reset();
		// RobotMap.Component.rightWheelEncoder.reset();
		// RobotMap.Input.elevatorSwitchBottom.whenPressed(new NeutralElevator()); //
		// TODO: Test if this is needed
		// RobotMap.Input.elevatorSwitchTop.whenPressed(new NeutralElevator());
		// RobotMap.Input.elevatorSwitchBottom.whenPressed(new SingleOp(() -> {
		// RobotMap.Component.elevatorEncoder.reset();
		// }));
		// RobotMap.Input.elevatorSwitchTop.whenPressed(new SingleOp(() -> {
		// RobotMap.Component.leftElevatorMotor.setSelectedSensorPosition((int)
		// FourBarElevator.MAX_HEIGHT, 0, 0);
		// })); // TODO: CustomEncoder should have a resetViaOffset
		// SmartDashboard.putNumber("ElevatorPID/P",
		// RobotMap.Component.elevatorPID.getP());
		// SmartDashboard.putNumber("ElevatorPID/I",
		// RobotMap.Component.elevatorPID.getI());
		// SmartDashboard.putNumber("ElevatorPID/D",
		// RobotMap.Component.elevatorPID.getD());
		// SmartDashboard.putNumber("ElevatorPID/F",
		// RobotMap.Component.elevatorPID.getF());
		// SmartDashboard.putNumber("DrivePID/P", RobotMap.Component.drivePID.getP());
		// SmartDashboard.putNumber("DrivePID/I", RobotMap.Component.drivePID.getI());
		// SmartDashboard.putNumber("DrivePID/D", RobotMap.Component.drivePID.getD());
		// SmartDashboard.putNumber("DrivePID/F", RobotMap.Component.drivePID.getF());
		// SmartDashboard.putNumber("TurnPID/P",
		// RobotMap.Component.chassisTurnPID.getP());
		// SmartDashboard.putNumber("TurnPID/I",
		// RobotMap.Component.chassisTurnPID.getI());
		// SmartDashboard.putNumber("TurnPID/D",
		// RobotMap.Component.chassisTurnPID.getD());
		// SmartDashboard.putNumber("TurnPID/F",
		// RobotMap.Component.chassisTurnPID.getF());
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
		// Just for testing encoder
		// SmartDashboard.putNumber("ElevatorPID/e",
		// RobotMap.Component.elevatorPID.getError());
		// SmartDashboard.putNumber("ElevatorPID/x",
		// RobotMap.Component.elevatorPID.getSensorValue());
		// RobotMap.Component.elevatorPID.setPIDF(SmartDashboard.getNumber("ElevatorPID/P",
		// 0.0),
		// SmartDashboard.getNumber("ElevatorPID/I", 0.0),
		// SmartDashboard.getNumber("ElevatorPID/D", 0.0),
		// SmartDashboard.getNumber("ElevatorPID/F", 0.0));
		// SmartDashboard.putNumber("DrivePID/e",
		// RobotMap.Component.drivePID.getError());
		// SmartDashboard.putNumber("DrivePID/x",
		// RobotMap.Component.drivePID.getSensorValue());
		// SmartDashboard.putNumber("TurnPID/e",
		// RobotMap.Component.chassisTurnPID.getError());
		// SmartDashboard.putNumber("TurnPID/x",
		// RobotMap.Component.chassisTurnPID.getSensorValue());
		// RobotMap.Component.drivePID.setPIDF(SmartDashboard.getNumber("DrivePID/P",
		// 0.0),
		// SmartDashboard.getNumber("DrivePID/I", 0.0),
		// SmartDashboard.getNumber("DrivePID/D", 0.0),
		// SmartDashboard.getNumber("DrivePID/F", 0.0));
		// RobotMap.Component.chassisTurnPID.setPIDF(SmartDashboard.getNumber("TurnPID/P",
		// 0.0),
		// SmartDashboard.getNumber("TurnPID/I", 0.0),
		// SmartDashboard.getNumber("TurnPID/D", 0.0),
		// SmartDashboard.getNumber("TurnPID/F", 0.0));
		// putSBSubsystemSummary();
	}

	void putSBSubsystemSummary() {
		String summary = "";
		for (Subsystem subsystem : RobotMap.Component.mainSubsystems) {
			summary += "{" + subsystem.getName() + "} running command {" + subsystem.getCurrentCommand() + "}\n";
		}
		SmartDashboard.putString("Subsystem Overview", summary);
		LogKitten.wtf("Subsystem Overview" + summary);
	}
}
