package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {}
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {}
    }
    
    public static class Metrics{}
    public static class PID{
        public static class Drive{
            public static final double P = 0.00004904;
			public static final double I = 0.0000000004904;
			public static final double D = 0.4904;
			public static final double F = 0.00004904;
			public static final double tolerance = 0.4904;
			public static final double dTolerance = 0.4904;
        }
        public static class Turn{
            public static final double P = 0.002;
			public static final double I = 0.0;
			public static final double D = -0.05;
			public static final double F = 0.2;
			public static final double tolerance = 1.0;
			public static final double dTolerance = 0.1;
        }
        public static class Elevator{
            public static final double P = 0.002;
			public static final double I = 0.0;
			public static final double D = -0.05;
			public static final double F = 0.2;
			public static final double tolerance = 1.0;
			public static final double dTolerance = 0.1;
        }
    }
    public static class Component {
        public static CustomXbox driverXbox;
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
