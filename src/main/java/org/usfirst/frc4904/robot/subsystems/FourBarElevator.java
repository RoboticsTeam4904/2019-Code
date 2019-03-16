package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.Overridable;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

public class FourBarElevator implements Overridable {
	public static final double UP_SPEED = 0.7; // TODO: SET THESE
	public static final double DOWN_SPEED = 0.7;
	public static final double UP_TIME = 0.5;
	public static final double DOWN_TIME = 0.5;
	public static final double ENCODER_TICKS = 1024;
	public static final double TICK_MULTIPLIER = 360.0 / ENCODER_TICKS;
	public static final double MIN_HEIGHT = 0.0;
	public static final double MAX_HEIGHT = 28.0;
	public static final double SPOOL_DIAMETER_INCHES = 1.5;
	public static final double SPOOL_CIRCUMFERENCE_INCHES = SPOOL_DIAMETER_INCHES * Math.PI;
	public static final Util.Range elevatorRange = new Util.Range(MIN_HEIGHT, MAX_HEIGHT);
	public final SolenoidSubsystem lever;
	public final PositionSensorMotor elevator;
	public State state;
	public boolean isOverridden;

	public FourBarElevator(SolenoidSubsystem lever, PositionSensorMotor elevator, boolean overriden) {
		this.lever = lever;
		this.elevator = elevator;
		this.setOverridden(overriden);
	}

	public FourBarElevator(SolenoidSubsystem lever, PositionSensorMotor elevator) {
		this(lever, elevator, false);
	}

	public enum State {
		HATCH_INTAKE(SolenoidState.RETRACT, 0.0), CARGO_INTAKE(SolenoidState.RETRACT, 10.0),
		LEVEL_ONE(SolenoidState.RETRACT, 8.0), LEVEL_TWO(SolenoidState.RETRACT, 28.0),
		LEVEL_THREE(SolenoidState.EXTEND, 28.0);
		// TODO: VALUES SUBJECT TO CHANGE
		public final SolenoidState fourBarState;
		public final double elevatorPosition;

		private State(SolenoidState fourBarState, double elevatorPosition) {
			this.fourBarState = fourBarState;
			this.elevatorPosition = elevatorPosition;
		}
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state; //this.lever.getState(), this.elevator.motioncontroller.getSensorValue
	}

	public double getElevatorPosition() {
		return RobotMap.Component.elevatorPID.getSensorValue();
	}

	public SolenoidState getFourBarState() {
		return lever.getState();
	}

	public void setOverridden(boolean override) {
		this.isOverridden = override;
	}

	public boolean isOverridden() {
		return isOverridden;
	}
}