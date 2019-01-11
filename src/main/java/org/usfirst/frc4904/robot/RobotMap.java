package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.subsystems.FloorIO;
import org.usfirst.frc4904.robot.subsystems.FloorIO.HatchHolder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int hatcherRollerIntake = 1;
            public static final int cargoRollerIntake = 2;
        }
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {

           public static final PCMPort hatchHolder = new PCMPort(1, 1, 1);
           public static final PCMPort flipper = new PCMPort(2, 2, 2);

        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;

        public static class Floorio {
            public static FloorIO floorio;
            public static FloorIO.HatchHolder hatchHolder;
            public static FloorIO.Flipper flipper;
            public static Motor cargoRollerIntake;
            public static Motor hatcherRollerIntake;
        }
    }
    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }
        public static class Operator {}
    }

    public RobotMap() {
        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
        Component.Floorio.cargoRollerIntake = new Motor("Cargo Rolller Intake", new CANTalonSRX(Port.CANMotor.cargoRollerIntake));
        Component.Floorio.hatcherRollerIntake = new Motor("Hatch Rolller Intake", new CANTalonSRX(Port.CANMotor.hatcherRollerIntake));



        Component.Floorio.flipper = new FloorIO.Flipper(Port.Pneumatics.flipper.buildDoubleSolenoid());
        Component.Floorio.hatchHolder = new FloorIO.HatchHolder(Port.Pneumatics.hatchHolder.buildDoubleSolenoid());


        Component.Floorio.floorio = new FloorIO(Component.Floorio.cargoRollerIntake,  Component.Floorio.hatcherRollerIntake, Component.Floorio.hatchHolder, Component.Floorio.flipper);        

        Component.driverXbox.setDeadZone(0.1);
    }
}
