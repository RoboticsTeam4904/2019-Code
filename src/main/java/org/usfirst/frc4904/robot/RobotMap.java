package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.custom.sensors.REVColorSensor;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.I2C;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class CANMotor {
            public static final int leftDriveA = 24; //TODO: MIGHT CHANGE
            public static final int leftDriveB = 2;
            public static final int rightDriveA = 3;
            public static final int rightDriveB = 4;
        }

        public static class PWM {
        }

        public static class CAN {
            public static final int leftEncoder = -1; //TODO: CHANGE PORTS
            public static final int rightEncoder = -1;
        }

        public static class Pneumatics {
            public static final PCMPort shifter = new PCMPort(-1, -1, -1); //TODO: CHANGE PORTS
        }

        public static class I2CDevice {
            public static final I2C.Port port = I2C.Port.kOnboard;
            public static final int whiteTapeLeft = -1; // TODO: CHANGE PORTS
            public static final int whiteTapeRight = -1;
        }
    }

    public static class Metrics {
        public static class Wheel {
            public static final double TICKS_PER_REVOLUTION = -1; //TODO: CHANGE CONSTS
            public static final double DIAMETER_INCHES = -1;
            public static final double CIRCUMFERENCE_INCHES = Metrics.Wheel.DIAMETER_INCHES * Math.PI;
            public static final double TICKS_PER_INCH = Metrics.Wheel.TICKS_PER_REVOLUTION
                / Metrics.Wheel.CIRCUMFERENCE_INCHES;
            public static final double DISTANCE_FRONT_BACK = -1;
            public static final double DISTANCE_SIDE_SIDE = -1;
            public static final double INCHES_PER_TICK = Metrics.Wheel.CIRCUMFERENCE_INCHES
                / Metrics.Wheel.TICKS_PER_REVOLUTION;
        }
    }

    public static class PID {
        public static class Drive {
            public static final double P = -1; // TODO: TUNE
            public static final double I = -1;
            public static final double D = -1;
            public static final double F = -1;
            public static final double tolerance = -1;
            public static final double dTolerance = -1;
        }

        public static class Turn {
            public static final double P = -1; // TODO: TUNE
            public static final double I = -1;
            public static final double D = -1;
            public static final double F = -1;
            public static final double tolerance = -1;
            public static final double dTolerance = -1;
        }
    }

    public static class Component {
        public static PDP pdp;
        public static TankDriveShifting chassis;
        public static Motor leftWheelA;
        public static Motor leftWheelB;
        public static Motor rightWheelA;
        public static Motor rightWheelB;
        public static SolenoidShifters shifter;
        public static EnableableModifier rightWheelAccelerationCap;
        public static EnableableModifier leftWheelAccelerationCap;
        public static CANEncoder leftWheelEncoder;
        public static CANEncoder rightWheelEncoder;
        public static EncoderPair chassisEncoders;
        public static CustomPIDController chassisTurnPID;
        public static CustomPIDController drivePID;
        public static NavX navx;
        public static REVColorSensor whiteTapeLeft;
        public static REVColorSensor whiteTapeRight;
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
        /* General */
        Component.pdp = new PDP();
        /* Drive Train */
        // Wheel Encoders
        Component.leftWheelEncoder = new CANEncoder("LeftEncoder", Port.CAN.leftEncoder);
        Component.rightWheelEncoder = new CANEncoder("RightEncoder", Port.CAN.rightEncoder);
        Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder, Component.rightWheelEncoder);
        Component.leftWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
        Component.rightWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
        Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.leftWheelAccelerationCap.enable();
        Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.rightWheelAccelerationCap.enable();
        // Wheels
        Component.rightWheelA = new Motor("rightWheelA", true, Component.rightWheelAccelerationCap,
            new CANTalonSRX(Port.CANMotor.rightDriveA));
        Component.rightWheelB = new Motor("rightWheelB", Component.rightWheelAccelerationCap,
            new CANTalonSRX(Port.CANMotor.rightDriveB));
        Component.leftWheelA = new Motor("leftWheelA", true, Component.leftWheelAccelerationCap,
            new CANTalonSRX(Port.CANMotor.leftDriveA));
        Component.leftWheelB = new Motor("leftWheelB", true, Component.leftWheelAccelerationCap,
            new CANTalonSRX(Port.CANMotor.leftDriveB));
        // Shifter
        Component.shifter = new SolenoidShifters(Port.Pneumatics.shifter.pcmID, Port.Pneumatics.shifter.forward,
            Port.Pneumatics.shifter.reverse);
        // General Chassis
        Component.chassis = new TankDriveShifting("2019-Chassis", Component.leftWheelA, Component.leftWheelB,
            Component.rightWheelA, Component.rightWheelB, Component.shifter);
        Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F,
            Component.rightWheelEncoder);
        Component.drivePID.setAbsoluteTolerance(PID.Drive.tolerance);
        Component.drivePID.setDerivativeTolerance(PID.Drive.dTolerance);
        Component.chassisTurnPID = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, Component.navx);
        Component.chassisTurnPID.setAbsoluteTolerance(PID.Turn.tolerance);
        Component.chassisTurnPID.setDerivativeTolerance(PID.Turn.dTolerance);
        // Human Input
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
        HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.JOYSTICK_DEADZONE);
        // Sensors
        Component.navx = new NavX(SerialPort.Port.kMXP);
        Component.whiteTapeLeft = new REVColorSensor(Port.I2CDevice.port, Port.I2CDevice.whiteTapeLeft);
        Component.whiteTapeRight = new REVColorSensor(Port.I2CDevice.port, Port.I2CDevice.whiteTapeRight);
    }
}
