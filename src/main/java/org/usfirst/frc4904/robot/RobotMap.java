package org.usfirst.frc4904.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.commands.PickupSolenoidDown;
import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.robot.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.robot.subsystems.VelcroPlate;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.motioncontrollers.Spark;



public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int hatcherRollerIntake = 14; // TODO: Adjust port numbers
            public static final int cargoRollerIntake = -1; // TODO: Adjust port numbers
            public static final int leftMotorA = 24;
            public static final int leftMotorB = 2;
            public static final int rightMotorA = 3;
            public static final int rightMotorB = 4;
            
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {

           public static final PCMPort pickupSolenoid = new PCMPort(0, 1, 0); // TODO: Adjust port numbers
           public static final PCMPort placeSolenoid = new PCMPort(0, 3, 2); // TODO: Adjust port numbers
           public static final PCMPort flipper = new PCMPort(-1, -1, -1); // TODO: Adjust port numbers

        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static FloorIO floorio;
        public static SolenoidSubsystem pickupSolenoid;
        public static SolenoidSubsystem placeSolenoid;
        public static SolenoidSubsystem flipper;
        public static Motor cargoRollerIntake;
        public static Motor hatcherRollerIntake;
        public static Motor leftMotorA;
        public static Motor leftMotorB;
        public static Motor rightMotorA;
        public static Motor rightMotorB;
        public static TankDrive chassis;
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
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Driver.xbox.setDeadZone(0.1);        
        Component.pickupSolenoid = new SolenoidSubsystem("PlaceSolenoid", Port.Pneumatics.pickupSolenoid.buildDoubleSolenoid());
        Component.placeSolenoid = new SolenoidSubsystem("PickupSolenoid", Port.Pneumatics.placeSolenoid.buildDoubleSolenoid());
        //Component.Floorio.cargoRollerIntake = new Motor("Cargo Roller Intake", new CANTalonSRX(Port.CANMotor.cargoRollerIntake));
        Component.hatcherRollerIntake = new Motor("Hatch Roller Intake", new CANTalonSRX(Port.CANMotor.hatcherRollerIntake));

        Component.flipper = new SolenoidSubsystem("Flipper", Port.Pneumatics.flipper.buildDoubleSolenoid());
        Component.floorio = new FloorIO(Component.placeSolenoid, Component.pickupSolenoid, Component.flipper, Component.hatcherRollerIntake);        

        Component.leftMotorA = new Motor("LeftMotorA", new Spark(Port.CANMotor.leftMotorA, MotorType.kBrushed));
        Component.leftMotorB = new Motor("LeftMotorB", true, new Spark(Port.CANMotor.leftMotorB, MotorType.kBrushed));
        Component.rightMotorA = new Motor("RightMotorA", true, new Spark(Port.CANMotor.rightMotorA, MotorType.kBrushed));
        Component.rightMotorB = new Motor("rightMotorB", true, new Spark(Port.CANMotor.rightMotorB, MotorType.kBrushed));        
        Component.chassis = new TankDrive("Chassis", Component.leftMotorA, Component.leftMotorB, Component.rightMotorA, Component.rightMotorB);
        
    }
}
