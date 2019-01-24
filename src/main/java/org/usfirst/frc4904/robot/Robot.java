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
import org.usfirst.frc4904.robot.commands.ExampleCommand;
import org.usfirst.frc4904.robot.commands.MonkeySee;
import org.usfirst.frc4904.robot.commands.MonkeyDo;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.SingleOp;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import edu.wpi.first.cameraserver.CameraServer;;


public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();
	private Command monkeySee;
	private Command monkeyDo;

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		// operatorChooser.addDefault();
		/* 
			works in shuffleboard with Logitech C270
			any amount of compression, 30 FPS, 160 x 120
			< 4 Mbps, often < 1
		*/
		// CameraServer.getInstance().startAutomaticCapture();

	}

	@Override
	public void teleopInitialize() {
		teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
		monkeySee = new MonkeySee();
		monkeySee.start();
		teleopCommand.start();
	}

	@Override
	public void teleopExecute() {}

	@Override
	public void autonomousInitialize() {
		monkeyDo = new MonkeyDo();
		monkeyDo.start();
	}

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
	public void alwaysExecute() {}
}
