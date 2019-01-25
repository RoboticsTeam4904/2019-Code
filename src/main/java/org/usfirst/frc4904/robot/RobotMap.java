package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.robot.subsystems.VelcroPlate;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int hatcherRollerIntake = -1; // TODO: Adjust port numbers
            public static final int cargoRollerIntake = -1; // TODO: Adjust port numbers
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {

           public static final PCMPort placeSolenoid = new PCMPort(-1, -1, -1); // TODO: Adjust port numbers
           public static final PCMPort pickupSolenoid = new PCMPort(-1, -1, -1); // TODO: Adjust port numbers
           public static final PCMPort flipper = new PCMPort(-1, -1, -1); // TODO: Adjust port numbers

        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;

        public static class Floorio {
            public static FloorIO floorio;
            public static VelcroPlate velcroPlate;
            public static DoubleSolenoid pickupSolenoid;
            public static DoubleSolenoid placeSolenoid;
            public static VelcroPlate.SolenoidWrapper pickupSolenoidWrapper;
            public static VelcroPlate.SolenoidWrapper placeSolenoidWrapper;
            public static FloorIO.Flipper flipper;
            public static Motor cargoRollerIntake;
            public static Motor hatcherRollerIntake;
        }
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
        
        Component.Floorio.cargoRollerIntake = new Motor("Cargo Roller Intake", new CANTalonSRX(Port.CANMotor.cargoRollerIntake));
        Component.Floorio.hatcherRollerIntake = new Motor("Hatch Roller Intake", new CANTalonSRX(Port.CANMotor.hatcherRollerIntake));

        Component.Floorio.flipper = new FloorIO.Flipper(Port.Pneumatics.flipper.buildDoubleSolenoid());
        Component.Floorio.velcroPlate = new VelcroPlate(Component.Floorio.pickupSolenoid, Component.Floorio.placeSolenoid);

        Component.Floorio.floorio = new FloorIO(Component.Floorio.cargoRollerIntake,  Component.Floorio.hatcherRollerIntake, Component.Floorio.velcroPlate, Component.Floorio.flipper);        

        Component.driverXbox.setDeadZone(0.1);
    }
}
