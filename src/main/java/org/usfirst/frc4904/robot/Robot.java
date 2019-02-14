/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4904.robot.commands.CameraStream;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		// driverChooser.addDefault(object);
		// operatorChooser.addDefault();
		CameraStream streamCommand = new CameraStream(2);
		streamCommand.start();
	}

	@Override
	public void teleopInitialize() {
		// teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		// teleopCommand.start();
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
	}
}
