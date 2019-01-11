package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;

import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.subsystems.ClawIO;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int ClawIOLeft = 0;
            public static final int ClawIORight = 1;
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {}
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        public static Motor clawIOLeft;
        public static Motor clawIORight;
        public static ClawIO clawIO;
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
        Component.clawIOLeft = new Motor("ClawIOLeft", new CANTalonSRX(Port.CANMotor.ClawIOLeft));
        Component.clawIORight = new Motor("ClawIORight", new CANTalonSRX(Port.CANMotor.ClawIORight));
        Component.clawIO = new ClawIO(Component.clawIOLeft, Component.clawIORight);

    }
}
