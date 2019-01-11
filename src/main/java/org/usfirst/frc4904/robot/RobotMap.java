package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import edu.wpi.first.wpilibj.XboxController;
import org.usfirst.frc4904.robot.subsystems.Base;

import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;
            public static final int joystick = 0;



        }
        public static class CANMotor {}
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {
            public static final PCMPort Base = new PCMPort(0,0,0);
        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        public static Base base;
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
        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
        Component.driverXbox.setDeadZone(0.1);
        Component.base = new Base(Port.Pneumatics.Base.buildDoubleSolenoid());
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
    }
}
