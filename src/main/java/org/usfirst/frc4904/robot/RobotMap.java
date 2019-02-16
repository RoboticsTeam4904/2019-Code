package org.usfirst.frc4904.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.I2C;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.sensors.REVColorSensor;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;
        }

        public static class CANMotor {
        }

        public static class PWM {
        }

        public static class CAN {
        }

        public static class Pneumatics {
        }
    }

    public static class Metrics {
    }

    public static class Component {
        public static CustomXbox driverXbox;
        public static REVColorSensor sensor;
    }

    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }

        public static class Operator {
        }
    }

    public RobotMap() {
        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
        Component.driverXbox.setDeadZone(0.1);
        Component.sensor = new REVColorSensor(I2C.Port.kOnboard);
    }
}
