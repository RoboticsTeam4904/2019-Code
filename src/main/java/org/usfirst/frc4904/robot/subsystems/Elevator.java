package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends PositionSensorMotor {
	public static final double UP_SPEED = 0.5;
	public static final double DOWN_SPEED = -0.5;
	public static final double ENCODER_TICKS = 1024;
	public static final double DISTANCE_PER_ROTATION = 0; //SET LATER
	public static final double TICK_MULTIPLIER = DISTANCE_PER_ROTATION;
	public final CANEncoder elevEncoder;

	public enum ElevState {
		UP(10), MIDDLE(5), DOWN(0); // TODO: NEED TO BE TWEAKED A LOOOOT, arbitrary numbers rn
		public final double position;

		private ElevState(double position) {
			this.position = position;
		}
	}

	public Elevator (MotionController motionController, CANEncoder elevEncoder, SpeedController... speedControllers) {
		super("Elevator", motionController, speedControllers);
		this.elevEncoder = elevEncoder;
	}

	public void setPosition (double position) {
		super.setPosition(position);
	}

	public void setPosition (ElevState state) {
		setPosition(state.position);
	}

	public void set (double speed) {
		super.set(speed);
	}
}