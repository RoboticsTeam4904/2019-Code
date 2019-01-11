package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.subsystems.VelcroPlate;
//import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
//import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
//import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
//import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            //public static final int velcroPlateMotor = -1;
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {
            //public static final PCMPort velcroPlatePistonGroup = new PCMPort(0, 0, 0); // TODO: Set values for PCMPort.
        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        /* Chassis */
        public static TankDriveShifting chassis;
        //public static Motor velcroPlateMotor;
        public static DoubleSolenoid velcroPlatePickup;
        public static DoubleSolenoid velcroPlatePlace;
        //public static CANEncoder velcroPlateEncoder;
        public static VelcroPlate velcroPlate;
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
        //Component.velcroPlateMotor = new Motor("VelcroPlateMotor", new CANTalonSRX(Port.CANMotor.velcroPlateMotor));
        Component.velcroPlate = new VelcroPlate(Component.velcroPlatePickup, Component.velcroPlatePlace);
    }
}
