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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.networktables.NetworkTable;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.cameraserver.CameraServer;



public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		// driverChooser.addDefault(object);
		// operatorChooser.addDefault();
		Shuffleboard.startRecording();
		Shuffleboard.enableActuatorWidgets();
		/* 
			works in shuffleboard with Logitech C270
			any amount of compression, 30 FPS, 160 x 120
			< 4 Mbps, often < 1
		*/
		CameraServer.getInstance().startAutomaticCapture();


	}

	@Override
	public void teleopInitialize() {
		// teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		// teleopCommand.start();
	}

	@Override
	public void teleopExecute() {}

	@Override
	public void autonomousInitialize() {}

	@Override
	public void autonomousExecute() {}

	@Override
	public void disabledInitialize() {}

	@Override
	public void disabledExecute() {}

	@Override
	public void testInitialize() {}

	@Override
	public void testExecute() {}

	@Override
	public void alwaysExecute() {
		Shuffleboard.update();
		RobotMap.NetworkTables.PID.driveP.setDouble(RobotMap.PID.Drive.P);
		RobotMap.NetworkTables.PID.driveI.setDouble(RobotMap.PID.Drive.I);
		RobotMap.NetworkTables.PID.driveD.setDouble(RobotMap.PID.Drive.D);
		RobotMap.NetworkTables.PID.driveF.setDouble(RobotMap.PID.Drive.F);
		RobotMap.NetworkTables.PID.driveError.setDouble(RobotMap.PID.Drive.e);
		RobotMap.NetworkTables.PID.turnP.setDouble(RobotMap.PID.Turn.P);
		RobotMap.NetworkTables.PID.turnI.setDouble(RobotMap.PID.Turn.I);
		RobotMap.NetworkTables.PID.turnD.setDouble(RobotMap.PID.Turn.D);
		RobotMap.NetworkTables.PID.turnF.setDouble(RobotMap.PID.Turn.F);
		RobotMap.NetworkTables.PID.turnError.setDouble(RobotMap.PID.Turn.e);
		RobotMap.NetworkTables.PID.elevP.setDouble(RobotMap.PID.Elevator.P);
		RobotMap.NetworkTables.PID.elevI.setDouble(RobotMap.PID.Elevator.I);
		RobotMap.NetworkTables.PID.elevD.setDouble(RobotMap.PID.Elevator.D);
		RobotMap.NetworkTables.PID.elevF.setDouble(RobotMap.PID.Elevator.F);
		RobotMap.NetworkTables.PID.elevError.setDouble(RobotMap.PID.Elevator.e);
	}
}
