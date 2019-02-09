package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.custom.Overridable;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends PositionSensorMotor implements Overridable {
	public static final double UP_SPEED = -1;
	public static final double DOWN_SPEED = -1;
	public static final double ENCODER_TICKS = -1;
	public static final double DISTANCE_PER_ROTATION = -1;
	public static final double TICK_MULTIPLIER = DISTANCE_PER_ROTATION;
	public static final double MIN_POSITION = -1;
	public static final double MAX_POSITION = -1;
	public final CANEncoder elevEncoder;
	public ElevState state = ElevState.UP;
	public boolean isOverridden;

	public enum ElevState {
		UP(-1), MIDDLE(-1), DOWN(-1);
		public final double position;

		private ElevState(double position) {
			this.position = position;
		}
	}

	public Elevator(MotionController motionController, CANEncoder elevEncoder, SpeedController... speedControllers) {
		super("Elevator", motionController, speedControllers);
		this.elevEncoder = elevEncoder; // TODO: this needs to be invertible?
	}

	public void setPosition(double position) {
		super.setPosition(position);
	}

	public void setPosition(ElevState state) {
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