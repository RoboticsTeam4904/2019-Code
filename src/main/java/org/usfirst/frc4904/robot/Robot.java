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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4904.robot.commands.elevator.NeutralElevator;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.robot.commands.CameraStream;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		CameraStream streamCommand = new CameraStream(1);
		streamCommand.start();
		// RobotMap.Component.leftWheelEncoder.reset();
		// RobotMap.Component.rightWheelEncoder.reset();
		// RobotMap.Input.elevatorSwitchBottom.whenPressed(new NeutralElevator());

		// TODO: Test if this is needed
		// RobotMap.Input.elevatorSwitchTop.whenPressed(new NeutralElevator());
		// RobotMap.Input.elevatorSwitchBottom.whenPressed(new SingleOp(() -> {
		// RobotMap.Component.elevatorEncoder.reset();
		// }));
		// RobotMap.Input.elevatorSwitchTop.whenPressed(new SingleOp(() -> {
		// RobotMap.Component.leftElevatorMotor.setSelectedSensorPosition((int)
		// FourBarElevator.MAX_HEIGHT, 0, 0);
	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		teleopCommand.start();

		// Command command = new SolenoidRetract(RobotMap.Component.manipulator.wrist);
		// command.start(); // RobotMap.initCommands
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
