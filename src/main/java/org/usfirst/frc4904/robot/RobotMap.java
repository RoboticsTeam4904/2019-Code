package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class RobotMap {
	public static class Port {
		public static class HumanInput {
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int hatchRoller = 14; // TODO: Adjust port numbers
			public static final int cargoRoller = 15; // TODO: Adjust port numbers
		}

		public static class PWM {
		}

		public static class CAN {
		}

		public static class Pneumatics {
			public static final PCMPort velcroPiston = new PCMPort(0, 1, 0); // TODO: Adjust port numbers
			public static final PCMPort pushPiston = new PCMPort(0, 3, 2); // TODO: Adjust port numbers
			public static final PCMPort wrist = new PCMPort(-1, -1, -1); // TODO: Adjust port numbers
		}
	}

	public static class Metrics {
	}

	public static class Component {
		public static FloorIO floorio;
		public static Motor cargoRoller;
		public static Motor hatchRoller;
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
		Component.floorio = new FloorIO(
			new SolenoidSubsystem("PushPiston", SolenoidState.RETRACT, Port.Pneumatics.pushPiston.buildDoubleSolenoid()),
			new SolenoidSubsystem("VelcroPiston", SolenoidState.RETRACT, Port.Pneumatics.velcroPiston.buildDoubleSolenoid()),
			new SolenoidSubsystem("Wrist", SolenoidState.RETRACT, Port.Pneumatics.wrist.buildDoubleSolenoid()),
			new Motor("HatchRoller", new CANTalonSRX(Port.CANMotor.hatchRoller)),
			new Motor("CargoRoller", new CANTalonSRX(Port.CANMotor.cargoRoller)));
	}
}
