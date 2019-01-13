package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.subsystems.CargoIO;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;
        }
        public static class CANMotor {
			public static final int cargoIORollerMotorTop = -1;
			public static final int cargoIORollerMotorBottom = -1;
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {}
    }
    
    public static class Metrics{}
    public static class Component {
		public static CustomXbox driverXbox;
		public static CargoIO cargoIO;
		public static Motor cargoIORollerTop;
		public static Motor cargoIORollerBottom;
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
		Component.cargoIORollerTop = new Motor("CargoIORollerTop", new CANTalonSRX(Port.CANMotor.cargoIORollerMotorTop));
		Component.cargoIORollerBottom = new Motor("CargoIORollerBottom", new CANTalonSRX(Port.CANMotor.cargoIORollerMotorBottom));
		Component.cargoIO = new CargoIO(Component.cargoIORollerTop, Component.cargoIORollerBottom);
    }
}
