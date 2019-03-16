package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.LogKitten.KittenLevel;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RobotMap {
	public static class Port {
		public static class HumanInput {
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int leftDriveA = 1;
			public static final int leftDriveB = 2;
			public static final int rightDriveA = 3;
			public static final int rightDriveB = 4;
			public static final int manipulatorRoller = 5;
			public static final int leftElevatorMotor = 7;
			public static final int rightElevatorMotor = 8;
		}

		public static class PWM {
		}

		public static class CAN {
			public static final int leftWheelEncoder = 0x612;
			public static final int rightWheelEncoder = 0x613;
		}

		public static class Pneumatics {
			public static final PCMPort wrist = new PCMPort(1, 7, 6); //TODO: Change pcms accordingly
			public static final PCMPort claws = new PCMPort(1, 2, 3);
			public static final PCMPort hatchExtender = new PCMPort(0, 2, 7);
			public static final PCMPort hatchGrabber = new PCMPort(0, 1, 0);
			public static final PCMPort shifter = new PCMPort(1, 4, 5);
			public static final PCMPort fourBarLever = new PCMPort(1, 1, 0);
		}

		public static class Digital {
			public static final int elevatorSwitchBottomPort = 0;
			public static final int elevatorSwitchTopPort = 1;
		}
	}

	public static class Metrics {
		public static class Chassis {
			public static final double TICKS_PER_REVOLUTION = -1; // TODO: CHANGE CONSTS
			public static final double DIAMETER_INCHES = -1;
			public static final double CIRCUMFERENCE_INCHES = Metrics.Chassis.DIAMETER_INCHES * Math.PI;
			public static final double TICKS_PER_INCH = Metrics.Chassis.TICKS_PER_REVOLUTION
				/ Metrics.Chassis.CIRCUMFERENCE_INCHES;
			public static final double DISTANCE_FRONT_BACK = -1;
			public static final double DISTANCE_SIDE_SIDE = -1;
			public static final double INCHES_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_INCHES
				/ Metrics.Chassis.TICKS_PER_REVOLUTION;
		}
	}

	public static class PID {
		public static class Drive {
			public static final double P = -1; // TODO: maybe TUNE
			public static final double I = -1;
			public static final double D = -1;
			public static final double F = -1;
			public static final double tolerance = -1;
			public static final double dTolerance = -1;
		}

		public static class Turn {
			public static final double P = -1; // TODO: TUNE
			public static final double I = -1;
			public static final double D = -1;
			public static final double F = -1;
			public static final double tolerance = -1;
			public static final double dTolerance = -1;
		}

		public static class Elevator {
			public static final double P = 0.07; // TODO: TUNE
			public static final double I = 0.000007;
			public static final double D = -0.0004;
			public static final double F = 0.0001;
			public static final double tolerance = 4.0;
			public static final double dTolerance = 3.0;
			// public static final double IThreshold = 13;
		}
	}

	// public Command[] initCommands;

	public static class Component { // TODO: Reorganize
		public static Manipulator manipulator;
		public static CANTalonEncoder elevatorEncoder;
		public static FourBarElevator fourBar; // TODO: Rename fourBar subsystem
		public static CustomPIDController elevatorPID;
		public static CANTalonSRX rightElevatorMotor;
		public static CANTalonSRX leftElevatorMotor;
		public static PDP pdp;
		public static TankDriveShifting chassis;
		public static Motor leftWheelA;
		public static Motor leftWheelB;
		public static Motor rightWheelA;
		public static Motor rightWheelB;
		public static SolenoidShifters shifter;
		public static EnableableModifier rightWheelAccelerationCap;
		public static EnableableModifier leftWheelAccelerationCap;
		public static CANEncoder leftWheelEncoder;
		public static CANEncoder rightWheelEncoder;
		public static EncoderPair chassisEncoders;
		public static CustomPIDController chassisTurnPID;
		public static CustomPIDController drivePID;
		public static NavX navx;
		public static Subsystem[] mainSubsystems;
	}

	public static class Input {
		public static DigitalInput elevatorSwitchBottom; // TODO: Move into fourBar subsystem
		public static DigitalInput elevatorSwitchTop;
	}

	public static class HumanInput {
		public static class Driver {
			public static CustomXbox xbox;
		}

		public static class Operator {
			public static CustomJoystick joystick;
		}
	}

	public RobotMap() {
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(0.1);
		HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
		/* General */
		Component.pdp = new PDP();
		// Component.navx = new NavX(SerialPort.Port.kMXP);
		/* Drive Train */
		// Wheel Encoders
		// Component.leftWheelEncoder = new CANEncoder("LeftEncoder",
		// Port.CAN.leftWheelEncoder,
		// Metrics.Chassis.INCHES_PER_TICK);
		// Component.rightWheelEncoder = new CANEncoder("RightEncoder",
		// Port.CAN.rightWheelEncoder,
		// Metrics.Chassis.INCHES_PER_TICK);
		// Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder,
		// Component.rightWheelEncoder);
		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.leftWheelAccelerationCap.enable();
		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.rightWheelAccelerationCap.enable();
		// Wheels
		Component.rightWheelA = new Motor("rightWheelA", false, Component.rightWheelAccelerationCap,
			new CANTalonSRX(Port.CANMotor.rightDriveA));
		Component.rightWheelB = new Motor("rightWheelB", false, Component.rightWheelAccelerationCap,
			new CANTalonSRX(Port.CANMotor.rightDriveB));
		Component.leftWheelA = new Motor("leftWheelA", true, Component.leftWheelAccelerationCap,
			new CANTalonSRX(Port.CANMotor.leftDriveA));
		Component.leftWheelB = new Motor("leftWheelB", true, Component.leftWheelAccelerationCap,
			new CANTalonSRX(Port.CANMotor.leftDriveB));
		// Shifter
		// Component.shifter = new SolenoidShifters(Port.Pneumatics.shifter.buildDoubleSolenoid());
		// General Chassis
		Component.chassis = new TankDriveShifting("2019-Chassis", Component.leftWheelA, Component.leftWheelB,
			Component.rightWheelA, Component.rightWheelB, Component.shifter);
		// Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I,
		// PID.Drive.D, PID.Drive.F,
		// Component.chassisEncoders);
		// Component.drivePID.setAbsoluteTolerance(PID.Drive.tolerance);
		// Component.drivePID.setDerivativeTolerance(PID.Drive.dTolerance);
		// Component.chassisTurnPID = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, Component.navx);
		// Component.chassisTurnPID.setAbsoluteTolerance(PID.Turn.tolerance);
		// Component.chassisTurnPID.setDerivativeTolerance(PID.Turn.dTolerance);
		/* Manipulator */
		Component.manipulator = new Manipulator(
			new SolenoidSubsystem("Manipulator Wrist",// SolenoidState.RETRACT,
				Port.Pneumatics.wrist.buildDoubleSolenoid()),
			new SolenoidSubsystem("Manipulator Claws",
				Port.Pneumatics.claws.buildDoubleSolenoid()),
			new SolenoidSubsystem("Manipulator Hatch Extender",// SolenoidState.RETRACT,
				Port.Pneumatics.hatchExtender.buildDoubleSolenoid()),
			new SolenoidSubsystem("Manipulator Hatch Grabber",// SolenoidState.EXTEND,
				Port.Pneumatics.hatchGrabber.buildDoubleSolenoid()),
			new Motor("Manipulator Roller", new CANTalonSRX(Port.CANMotor.manipulatorRoller)),
			true); // Override safety checks for pistons
			Component.manipulator.roller.setInverted(true);
		/* Elevator + FourBar */
		Component.rightElevatorMotor = new CANTalonSRX(Port.CANMotor.rightElevatorMotor);
		Component.rightElevatorMotor.setInverted(true);
		Component.leftElevatorMotor = new CANTalonSRX(Port.CANMotor.leftElevatorMotor);
		Component.elevatorEncoder = new CANTalonEncoder(Component.leftElevatorMotor,
			FourBarElevator.TICK_MULTIPLIER);
		Component.elevatorPID = new CustomPIDController(PID.Elevator.P,
			PID.Elevator.I, PID.Elevator.D, PID.Elevator.F,
			Component.elevatorEncoder);
		Component.leftElevatorMotor.setNeutralMode(NeutralMode.Brake);
		Component.rightElevatorMotor.setNeutralMode(NeutralMode.Brake);
		Component.fourBar = new FourBarElevator(
			new SolenoidSubsystem("FourBarLever",
				Port.Pneumatics.fourBarLever.buildDoubleSolenoid()),
			new PositionSensorMotor("Elevator", Component.elevatorPID,
				Component.leftElevatorMotor,
				Component.rightElevatorMotor),
			true); // Override safety checks for reed switches
		// Component.elevatorPID.setAbsoluteTolerance(PID.Elevator.tolerance);
		// Component.elevatorPID.setDerivativeTolerance(PID.Elevator.dTolerance);
		Input.elevatorSwitchBottom = new
			DigitalInput(Port.Digital.elevatorSwitchBottomPort);
		Input.elevatorSwitchTop = new
			DigitalInput(Port.Digital.elevatorSwitchTopPort);
		// Input.elevatorSwitchBottom.whenPressed(new KittenCommand("Bottom switch activated", KittenLevel.WTF));
		// Input.elevatorSwitchTop.whenPressed(new KittenCommand("Top switch activated", KittenLevel.WTF));
		/* Human Input */
		HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
		HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
		HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
		HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.JOYSTICK_DEADZONE);
		/* Main Subsystems */
		Component.mainSubsystems = new Subsystem[] {Component.fourBar.lever, Component.manipulator.hatchExtender, Component.manipulator.hatchGrabber, Component.manipulator.claws, Component.manipulator.wrist};
		// Component.mainSubsystems = new Subsystem[] { Component.chassis,
		// Component.fourBar.lever,
		// Component.fourBar.elevator, Component.floorio.hatchOuttakePiston,
		// Component.floorio.velcroPiston,
		// Component.floorio.wrist, Component.floorio.hatchRoller,
		// Component.floorio.cargoRoller };
	}
}
