package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.robot.subsystems.Manipulator;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {}
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {
			// public static PCMPort 
		}
    }
    
    public static class Metrics{}
    public static class Component {
		public static CustomXbox driverXbox;
		public static Manipulator manipulator;
		public static SolenoidSubsystem manipulatorArm;
		public static SolenoidSubsystem manipulatorClaws;
		public static SolenoidSubsystem manipulatorGround;
		public static SolenoidSubsystem manipulatorGrabber;
    }
    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }
        public static class Operator {}
    }
    public RobotMap() {
        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
		Component.driverXbox.setDeadZone(0.1);
    }
}
