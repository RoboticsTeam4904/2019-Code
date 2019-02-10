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
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;


public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();
	VideoSink server;
	UsbCamera camera0;
	UsbCamera camera1;
	long counter;

	@Override
	public void initialize() {
		// driverChooser.addDefault(object);
		// operatorChooser.addDefault();
		/*
		 * works in shuffleboard with Logitech C270
		 * any amount of compression, 30 FPS, 160 x 120
		 * < 4 Mbps, often < 1
		 */
		camera0 = CameraServer.getInstance().startAutomaticCapture(0);
		camera1 = CameraServer.getInstance().startAutomaticCapture(1);
		server = CameraServer.getInstance().getServer();
		camera0.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 360, 30);
		camera0.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
		camera1.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 360, 30);
		camera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
		counter = 0L;
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
		++counter;
		if(counter % 50 == 0){
			if(server.getSource() == camera0){
				server.setSource(camera1);
			} else {
				server.setSource(camera0);
			}
		}
		
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
