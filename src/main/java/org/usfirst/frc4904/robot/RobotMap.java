package org.usfirst.frc4904.robot;


import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.robot.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.custom.motioncontrollers.Spark;

public class RobotMap {
	public static class Port {
		public static class HumanInput {
			public static final int xboxController = 1;
		}

		public static class CANMotor {
			public static final int hatcherRollerIntake = 14; // TODO: Adjust port numbers
			public static final int cargoRollerIntake = 15; // TODO: Adjust port numbers
		}

		public static class PWM {
		}

		public static class CAN {
		}

		public static class Pneumatics {
			public static final PCMPort pickupSolenoid = new PCMPort(0, 1, 0); // TODO: Adjust port numbers
			public static final PCMPort placeSolenoid = new PCMPort(0, 3, 2); // TODO: Adjust port numbers
			public static final PCMPort flipper = new PCMPort(-1, -1, -1); // TODO: Adjust port numbers
		}
	}

	public static class Metrics {
	}

	public static class Component {
		public static FloorIO floorio;
		public static SolenoidSubsystem velcroPiston;
		public static SolenoidSubsystem pushPiston;
		public static SolenoidSubsystem flipper;
		public static Motor cargoRollerIntake;
		public static Motor hatcherRollerIntake;
		public static Motor leftMotorA;
		public static Motor leftMotorB;
		public static Motor rightMotorA;
		public static Motor rightMotorB;
		public static TankDrive chassis;
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
		Component.velcroPiston = new SolenoidSubsystem("VelcroPiston", Port.Pneumatics.pickupSolenoid.buildDoubleSolenoid());
		Component.pushPiston = new SolenoidSubsystem("PushPiston", Port.Pneumatics.placeSolenoid.buildDoubleSolenoid());
		Component.cargoRollerIntake = new Motor("CargoRollerIntake", new CANTalonSRX(Port.CANMotor.cargoRollerIntake));
		Component.hatcherRollerIntake = new Motor("HatchRollerIntake", new CANTalonSRX(Port.CANMotor.hatcherRollerIntake));
		Component.floorio = new FloorIO(Component.pushPiston, Component.velcroPiston, Component.flipper,
			Component.hatcherRollerIntake, Component.cargoRollerIntake);
	}
}
