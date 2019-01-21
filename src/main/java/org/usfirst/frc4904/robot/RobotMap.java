package org.usfirst.frc4904.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc4904.standard.custom.motioncontrollers.Spark;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int leftMotorA = 24;
            public static final int leftMotorB = 2;
            public static final int rightMotorA = 3;
            public static final int rightMotorB = 4;
            
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {
            public static final PCMPort port = new PCMPort(0, 1, 0);
        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        public static Motor leftMotorA;
        public static Motor leftMotorB;
        public static Motor rightMotorA;
        public static Motor rightMotorB;
        public static DoubleSolenoid solenoid;

        public static TankDrive chassis;
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
        Component.solenoid = Port.Pneumatics.port.buildDoubleSolenoid();

        Component.leftMotorA = new Motor("LeftMotorA", new Spark(Port.CANMotor.leftMotorA, MotorType.kBrushed));
        Component.leftMotorB = new Motor("LeftMotorB", true, new Spark(Port.CANMotor.leftMotorB, MotorType.kBrushed));
        Component.rightMotorA = new Motor("RightMotorA", true, new Spark(Port.CANMotor.rightMotorA, MotorType.kBrushed));
        Component.rightMotorB = new Motor("rightMotorB", true, new Spark(Port.CANMotor.rightMotorB, MotorType.kBrushed));        
        Component.chassis = new TankDrive("Chassis", Component.leftMotorA, Component.leftMotorB, Component.rightMotorA, Component.rightMotorB);
        
    }
}
