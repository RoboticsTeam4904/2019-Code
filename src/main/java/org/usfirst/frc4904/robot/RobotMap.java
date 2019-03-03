package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.subsystems.Manipulator;

public class RobotMap {
	public static class Port {
		public static class HumanInput {
			public static final int joystick = 0;
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static int manipulatorRoller = -1;
		}

		public static class PWM {
		}

		public static class CAN {
		}

		public static class Pneumatics {
			public static PCMPort manipulatorArm = new PCMPort(-1, -1, -1);
			public static PCMPort manipulatorClaws = new PCMPort(-1, -1, -1);
			public static PCMPort manipulatorGround = new PCMPort(-1, -1, -1);
			public static PCMPort manipulatorGrabber = new PCMPort(-1, -1, -1);
		}
	}

	public static class Metrics {
	}

	public static class Component {
		public static Manipulator manipulator;
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
		Component.manipulator = new Manipulator(
			new SolenoidSubsystem("Manipulator Arm", SolenoidState.EXTEND,
				Port.Pneumatics.manipulatorArm.buildDoubleSolenoid()),
			new SolenoidSubsystem("Manipulator Claws", SolenoidState.EXTEND,
				Port.Pneumatics.manipulatorClaws.buildDoubleSolenoid()),
			new SolenoidSubsystem("Manipulator Ground", SolenoidState.EXTEND,
				Port.Pneumatics.manipulatorGround.buildDoubleSolenoid()),
			new SolenoidSubsystem("Manipulator Grabber", SolenoidState.EXTEND,
				Port.Pneumatics.manipulatorGrabber.buildDoubleSolenoid()),
			new Motor("Manipulator Roller", new CANTalonSRX(Port.CANMotor.manipulatorRoller)));
	}
}
