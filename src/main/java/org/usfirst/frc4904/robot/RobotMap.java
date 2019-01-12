package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.robot.subsystems.ProngIO;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.PCMPort;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int prongIOExpanderMotor = -1; //Define CANMotor.prongIOExpanderMotor with a correct port.
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {
            public static final PCMPort prongIOPusher = new PCMPort(-1, -1, -1); //Define Pneumatics.prongIOPusher with a correct port.
        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        public static Motor prongIOExpander;
        public static ProngIO.Pusher prongIOPusher;
        public static ProngIO prongIO;
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
        Component.prongIOExpander = new Motor("ProngIOExpanderMotor",
			new CANTalonSRX(Port.CANMotor.prongIOExpanderMotor));
        Component.prongIOPusher = new ProngIO.Pusher(Port.Pneumatics.prongIOPusher.buildDoubleSolenoid());
        Component.prongIO = new ProngIO(Component.prongIOExpander, Component.prongIOPusher);
    }
}
