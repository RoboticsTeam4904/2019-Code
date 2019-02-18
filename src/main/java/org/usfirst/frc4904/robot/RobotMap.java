package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.PCMPort;

public class RobotMap {
	public static class Port {
		public static class HumanInput {
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int rightElevatorMotor = 8;
			public static final int leftElevatorMotor = 7;
		}

		public static class CAN {
			public static final int elevatorEncoder = 1; // also not final #
		}

		public static class Pneumatics {
			public static final PCMPort fourBarLever = new PCMPort(-1, -1, -1);
		}

		public static class Digital {
			public static final int elevatorSwitchBottomPort = -1; // TODO: Not final values.
			public static final int elevatorSwitchTopPort = -1;
		}
	}

	public static class Metrics {
	}

	public static class PID {
		public static class Elevator {
			public static final double P = 1; // TODO: TUNE
			public static final double I = 1;
			public static final double D = 1;
			public static final double F = 1;
			public static final double tolerance = -1;
			public static final double dTolerance = -1;
			public static final double IThreshold = -1;
		}
	}

	public static class Component {
		public static CustomXbox driverXbox;
		public static CANEncoder elevatorEncoder;
		public static FourBarElevator fourBar;
		public static CustomPIDController elevatorPID;
		public static CANTalonSRX rightElevatorMotor;
		public static CANTalonSRX leftElevatorMotor;
		public static Subsystem[] mainSubsystems;
	}

	public static class HumanInput {
		public static class Driver {
			public static CustomXbox xbox;
		}

		public static class Operator {
			public static CustomJoystick joystick;
		}
	}

	public static class Input {
		public static CustomDigitalLimitSwitch elevatorSwitchBottom;
		public static CustomDigitalLimitSwitch elevatorSwitchTop;
	}

	public RobotMap() {
		Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
		Component.driverXbox.setDeadZone(0.1);
		HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
		Component.elevatorEncoder = new CANEncoder(Port.CAN.elevatorEncoder, FourBarElevator.TICK_MULTIPLIER);
		Component.elevatorPID = new CustomPIDController(PID.Elevator.P, PID.Elevator.I, PID.Elevator.D, PID.Elevator.F,
			Component.elevatorEncoder);
		Component.elevatorPID.setAbsoluteTolerance(PID.Elevator.tolerance);
		Component.elevatorPID.setDerivativeTolerance(PID.Elevator.dTolerance);
		Component.elevatorPID.setIThreshold(PID.Elevator.IThreshold);
		Component.rightElevatorMotor = new CANTalonSRX(Port.CANMotor.rightElevatorMotor);
		Component.rightElevatorMotor.setInverted(true);
		Component.leftElevatorMotor = new CANTalonSRX(Port.CANMotor.leftElevatorMotor);
		Component.fourBar = new FourBarElevator(
			new PositionSensorMotor("Elevator", Component.elevatorPID,
				Component.leftElevatorMotor,
				Component.rightElevatorMotor));
		Input.elevatorSwitchBottom = new CustomDigitalLimitSwitch(Port.Digital.elevatorSwitchBottomPort);
		Input.elevatorSwitchTop = new CustomDigitalLimitSwitch(Port.Digital.elevatorSwitchTopPort);
		Component.mainSubsystems = new Subsystem[] {Component.fourBar.elevator};
	}
}
