package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.PCMPort;

// Config file to gitignore. TODO: Use JSON

public class Penelope {
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
			public static final PCMPort wrist = new PCMPort(1, 0, 1);
			public static final PCMPort claws = new PCMPort(0, 3, 2);
			public static final PCMPort hatchExtender = new PCMPort(0, 5, 4);
			public static final PCMPort hatchGrabber = new PCMPort(0, 0, 1);
			public static final PCMPort shifter = new PCMPort(0, 6, 7);
			public static final PCMPort fourBarLever = new PCMPort(1, 3, 2);
		}

		public static class Digital {
			public static final int elevatorSwitchBottomPort = 0;
			public static final int elevatorSwitchTopPort = 1;
		}
	}
	// TODO: Add PID and dimensions for wheels and such.
	// TODO: Add handlers for missing subsystems (sigh), including examples as extreme as pinky
}
