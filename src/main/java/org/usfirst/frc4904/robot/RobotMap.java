package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.subsystems.Elevator;
import org.usfirst.frc4904.robot.subsystems.FourBarLinkage;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.PCMPort;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class CANMotor {
            public static final int elevMotor1 = -1;
            public static final int elevMotor2 = -1;
        }

        public static class PWM {
        }

        public static class CAN {
            public static final int elevCANEncoder = -1;
        }

        public static class Pneumatics {
            public static final PCMPort fourBarLever = new PCMPort(-1, -1, -1);
        }
    }

    public static class Metrics {
    }

    public static class PID {
        public static class Elevator {
            public static final double P = -1;
            public static final double I = -1;
            public static final double D = -1;
            public static final double F = -1;
        }
    }

    public static class Component {
        public static Elevator elevator;
        public static CANEncoder elevCANEncoder;
        public static FourBarLinkage fourBar;
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
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
        HumanInput.Operator.joystick.setDeadzone(0.1);
        Component.elevCANEncoder = new CANEncoder(Port.CAN.elevCANEncoder);
        Component.elevCANEncoder.setDistancePerPulse(Elevator.TICK_MULTIPLIER);
        Component.elevator = new Elevator(
            new CustomPIDController(PID.Elevator.P, PID.Elevator.I, PID.Elevator.D, PID.Elevator.F, Component.elevCANEncoder),
            Component.elevCANEncoder, new CANTalonSRX(Port.CANMotor.elevMotor1), new CANTalonSRX(Port.CANMotor.elevMotor2));
        Component.fourBar = new FourBarLinkage(Port.Pneumatics.fourBarLever.buildDoubleSolenoid());
    }
}
