package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.robot.subsystems.Elevator;
import org.usfirst.frc4904.robot.subsystems.FourBarLinkage;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.PCMPort;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class CANMotor {
            public static final int elevatorMotorA = 1; // not final numbers
            public static final int elevatorMotorB = 2;
        }

        public static class CAN {
            public static final int elevatorEncoder = 1; // also not final #
        }

        public static class Pneumatics {
            public static final PCMPort fourBarLever = new PCMPort(-1, -1, -1);
        }

        public static class Digital {
            public static final int elevatorSwitchBottomPort = -1; // TODO: Not final values.
            public static final int elevatorSwitchTopPort = -1;
        }
    }

    public static class Metrics {
        public static final double ELEVATOR_INNER_HEIGHT = -1; // TODO: set to actual value
    }

    public static class PID {
        public static class Elevator {
            public static final double P = 1; // TODO: TUNE
            public static final double I = 1;
            public static final double D = 1;
            public static final double F = 1;
        }
    }

    public static class Component {
        public static CustomXbox driverXbox;
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

    public static class Input {
        public static CustomDigitalLimitSwitch elevatorSwitchBottom;
        public static CustomDigitalLimitSwitch elevatorSwitchTop;
    }

    public RobotMap() {
        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
        Component.driverXbox.setDeadZone(0.1);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
        Component.elevCANEncoder = new CANEncoder(Port.CAN.elevatorEncoder);
        Component.elevCANEncoder.setDistancePerPulse(Elevator.TICK_MULTIPLIER);
        Component.elevator = new Elevator(
            new CustomPIDController(PID.Elevator.P, PID.Elevator.I, PID.Elevator.D, PID.Elevator.F, Component.elevCANEncoder),
            Component.elevCANEncoder, new CANTalonSRX(Port.CANMotor.elevatorMotorA),
            new CANTalonSRX(Port.CANMotor.elevatorMotorB));
        Component.fourBar = new FourBarLinkage(Port.Pneumatics.fourBarLever.buildDoubleSolenoid());
        Input.elevatorSwitchBottom = new CustomDigitalLimitSwitch(Port.Digital.elevatorSwitchBottomPort);
        Input.elevatorSwitchTop = new CustomDigitalLimitSwitch(Port.Digital.elevatorSwitchTopPort);
    }
}
