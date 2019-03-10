package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.Overridable;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;

public class Elevator extends Motor implements Overridable {
	public static final double UP_SPEED = 0.7; // TODO: SET THESE
	public static final double DOWN_SPEED = 0.7;
	public static final double ENCODER_TICKS = 1024;
	public static final double TICK_MULTIPLIER = 360.0 / ENCODER_TICKS;
	public static final double MIN_HEIGHT = 0.0;
	public static final double MAX_HEIGHT = 28.0;
	public static final double SPOOL_DIAMETER_INCHES = 1.5;
	public static final double SPOOL_CIRCUMFERENCE_INCHES = SPOOL_DIAMETER_INCHES * Math.PI;
	public static final Util.Range elevatorRange = new Util.Range(MIN_HEIGHT, MAX_HEIGHT);

	public Elevator(MotionController motionController, SpeedController... motors) {
		super(motionController, motors);
	}
}