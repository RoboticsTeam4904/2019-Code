package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.robot.subsystems.Climber;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.custom.PCMPort;



public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;
            public static final int joystick = 0; //Change port later
        }
        public static class CANMotor {}
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {
            public static final PCMPort climberFrontLift = new PCMPort(-1, -1, -1); //Define Pneumatics.prongIOPusher with a correct port.
            public static final PCMPort climberBackLift = new PCMPort(-1, -1, -1); //Define Pneumatics.prongIOPusher with a correct port.
        }
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        public static Climber.FrontLift climberFrontLift;
        public static Climber.BackLift climberBackLift;
        public static Climber climber;
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
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
        Component.climberFrontLift = new Climber.FrontLift(Port.Pneumatics.climberFrontLift.buildDoubleSolenoid());
        Component.climberBackLift = new Climber.BackLift(Port.Pneumatics.climberBackLift.buildDoubleSolenoid());
        Component.climber = new Climber(Component.climberFrontLift, Component.climberBackLift);

    }
}
