package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomEncoder;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.custom.sensors.PIDSensor;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.usfirst.frc4904.robot.subsystems.Tim;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int timIntake = 0;
            public static final int timIndex = 1;
        }
        public static class PWM {}
        public static class CAN {
            public static final int timEncoder=0;
        }
        public static class Pneumatics {}
    }
    
    public static class Metrics{}
    public static class Component {
        public static CustomXbox driverXbox;
        public static Tim tim;
        public static CANEncoder timEncoder;
        public static CustomPIDController timRotateController;
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

        Component.timEncoder = new CANEncoder("Tim Rotate Encoder", Port.CAN.timEncoder);
        Component.timRotateController = new CustomPIDController(Tim.TIM_P, Tim.TIM_I, Tim.TIM_D, Component.timEncoder);
		Component.timRotateController.setAbsoluteTolerance(Tim.TIM_ABSOLUTE_TOLERANCE);

        Component.tim = new Tim(Component.timEncoder, new CANTalonSRX(Port.CANMotor.timIntake), Component.timRotateController, new CANTalonSRX(Port.CANMotor.timIndex));
    }
}
