package org.usfirst.frc4904.robot;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;

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
        public static final int streamingXRes = 640; // TODO: move these somewhere else?
        public static final int streamingYRes = 360;
        public static final int streamingFPS = 30;
        public static final VideoMode.PixelFormat streamingFmt = PixelFormat.kMJPEG;
    }

    public static class Component {
        public static CustomXbox driverXbox;
        public static UsbCamera streamingCameraA;
        public static UsbCamera streamingCameraB;
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
    }
}
