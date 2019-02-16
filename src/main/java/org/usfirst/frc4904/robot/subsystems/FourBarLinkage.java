package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.custom.Overridable;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

public class FourBarLinkage implements Overridable {
	public static final double UP_SPEED = 0.5; // TODO: SET THESE
	public static final double DOWN_SPEED = 0.5;
	public static final double ENCODER_TICKS = -1;
	public static final double DISTANCE_PER_ROTATION = -1;
	public static final double TICK_MULTIPLIER = DISTANCE_PER_ROTATION;
	public static final double MIN_POSITION = 0;
	public static final double MAX_POSITION = 90;
	public final SolenoidSubsystem lever;
	public final PositionSensorMotor elevator;
	public FourBarState state;
	public boolean isOverridden;

	public FourBarLinkage(SolenoidSubsystem lever, PositionSensorMotor elevator) {
		this.lever = lever;
		this.elevator = elevator;
	}

	public enum FourBarState {
		HATCH_INTAKE(SolenoidState.RETRACT, 0.0), CARGO_INTAKE(SolenoidState.RETRACT, 10.0), LEVEL_ONE(SolenoidState.RETRACT,
			30.0), LEVEL_TWO(SolenoidState.RETRACT, 30.0), LEVEL_THREE(SolenoidState.EXTEND, 50.0);
		// TODO: VALUES SUBJECT TO CHANGE
		public final SolenoidState fourBarState;
		public final double elevatorPosition;

		private FourBarState(SolenoidState fourBarState, double elevatorPosition) {
			this.fourBarState = fourBarState;
			this.elevatorPosition = elevatorPosition;
		}
	}

	public void setPosition(SolenoidState fourBarState, double elevatorPosition) {
		//TODO: Set the wrist up before doing this if going to LEVEL_ONE or above
		lever.set(fourBarState);
		elevator.setPosition(elevatorPosition);
	}

	public void setPosition(FourBarState state) {
		setPosition(state.fourBarState, state.elevatorPosition);
	}

	public FourBarState getState() {
		return state;
	}

	public void setOverridden(boolean override) {
		this.isOverridden = override;
	}

	public boolean isOverridden() {
		return isOverridden;
	}
}