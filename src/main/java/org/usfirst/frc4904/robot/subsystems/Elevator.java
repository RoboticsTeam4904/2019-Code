package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.custom.Overridable;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.SpeedController;

public class Elevator extends PositionSensorMotor implements Overridable {
	public static final double UP_SPEED = 0.5; //TODO: SET THESE
	public static final double DOWN_SPEED = 0.5;
	public static final double ENCODER_TICKS = -1;
	public static final double DISTANCE_PER_ROTATION = -1;
	public static final double TICK_MULTIPLIER = DISTANCE_PER_ROTATION;
	public static final double MIN_POSITION = 0;
	public static final double MAX_POSITION = 90;
	public final CANEncoder elevatorEncoder;
	public ElevatorState state = ElevatorState.UP;
	public boolean isOverridden;

	public enum ElevatorState {
		UP(-1), MIDDLE(-1), DOWN(-1);
		public final double position;

		private ElevatorState(double position) {
			this.position = position;
		}
	}

	public Elevator(MotionController motionController, CANEncoder elevEncoder, SpeedController... speedControllers) {
		super("Elevator", motionController, speedControllers);
		this.elevatorEncoder = elevEncoder;
	}

	public void setPosition(double position) {
		super.setPosition(position);
	}

	public void setPosition(ElevatorState state) {
		setPosition(state.position);
		this.state = state;
	}

	public void set(double speed) {
		super.set(speed);
	}

	public double getPosition() {
		return state.position;
	}

	public void setOverridden(boolean override) {
		this.isOverridden = override;
	}

	public boolean isOverridden() {
		return isOverridden;
	}
}