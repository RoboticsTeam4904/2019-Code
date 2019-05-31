/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.motioncontrol.pathing.SplineGenerator;
import org.usfirst.frc4904.robot.autonly.SplineFollower;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends CommandRobotBase {
	private RobotMap map = new RobotMap();

	@Override
	public void initialize() {
		driverChooser.addDefault(new NathanGain());
		operatorChooser.addDefault(new DefaultOperator());
		autoChooser.addDefault(new SplineFollower(SplineGenerator.fitQuintic(
			0, 0, 10, 20,
			20, 0, 0, 20,
			1, 0, 0, -1), 1, 0, 0, .2, 0)); // TODO: Tune these PIDVA values
		/*
		 * works in shuffleboard with Logitech C270
		 * any amount of compression, 30 FPS, 160 x 120
		 * < 4 Mbps, often < 1
		 */
		CameraServer.getInstance().startAutomaticCapture();
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
	}
}
