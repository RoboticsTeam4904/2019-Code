package org.usfirst.frc4904.robot;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc4904.standard.custom.motioncontrollers.Spark;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.auton.Fusible;
import org.usfirst.frc4904.auton.FusibleNavX;
import org.usfirst.frc4904.auton.AligningCamera;
import org.usfirst.frc4904.auton.DummyCamera;
import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import edu.wpi.first.wpilibj.SerialPort;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            // public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class PWM {
        }

        public static class CAN {
            // public static final int leftEncoder = -1; // TODO: Change ports
            // public static final int rightEncoder = -1;
        }

        public static class Pneumatics {
            // public static final PCMPort shifter = new PCMPort(-1, -1, -1); // TODO: Change ports
        }

        public static class CANMotor {
            public static final int leftMotorA = 24;
            public static final int leftMotorB = 2;
            public static final int rightMotorA = 3;
            public static final int rightMotorB = 4;
        }
    }

    public static class Metrics {
        public static class Wheel {
            public static final double TICKS_PER_REVOLUTION = 4.904; // Obviously not real metrics
            public static final double DIAMETER_INCHES = 4.904;
            public static final double CIRCUMFERENCE_INCHES = Metrics.Wheel.DIAMETER_INCHES * Math.PI;
            public static final double TICKS_PER_INCH = Metrics.Wheel.TICKS_PER_REVOLUTION
                / Metrics.Wheel.CIRCUMFERENCE_INCHES;
            public static final double DISTANCE_FRONT_BACK = 4.904;
            public static final double DISTANCE_SIDE_SIDE = 4.904;
            public static final double INCHES_PER_TICK = Metrics.Wheel.CIRCUMFERENCE_INCHES
                / Metrics.Wheel.TICKS_PER_REVOLUTION;
        }
    }

    public static class PID {
        public static class Drive {
            public static final double P = 0.04; // Tune PID
            public static final double I = 0.0; // Tune PID
            public static final double D = -0.006; // Tune PID
            public static final double F = 0.01; // Tune PID
            public static final double tolerance = 4.5; // Tune PID
            public static final double dTolerance = 3.0; // Tune PID
        }

        public static class PWM {
        }

        public static class CAN {
        }

        public static class Pneumatics {
            public static final PCMPort port = new PCMPort(0, 1, 0);
        }
    }

    public static class Component {
        public static PDP pdp;
        // public static TankDriveShifting chassis;
        public static TankDrive chassis;
        public static Motor leftWheelA;
        public static Motor leftWheelB;
        public static Motor rightWheelA;
        public static Motor rightWheelB;
        public static Motor leftWheel;
        public static Motor rightWheel;
        public static SolenoidShifters shifter;
        public static EnableableModifier rightWheelAccelerationCap;
        public static EnableableModifier leftWheelAccelerationCap;
        public static CANEncoder leftWheelEncoder;
        public static CANEncoder rightWheelEncoder;
        public static EncoderPair chassisEncoders;
        public static CustomPIDController chassisTurnMC;
        public static CustomPIDController drivePID;
        public static FusibleNavX navx;
        public static DummyCamera alignmentCamera;
        public static CustomXbox driverXbox;
        public static Motor leftMotorA;
        public static Motor leftMotorB;
        public static Motor rightMotorA;
        public static Motor rightMotorB;
        public static DoubleSolenoid solenoid;
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
        Component.pdp = new PDP();
        // Wheels
        // Component.leftWheelEncoder = new CANEncoder("LeftEncoder", Port.CAN.leftEncoder);
        // Component.rightWheelEncoder = new CANEncoder("RightEncoder", Port.CAN.rightEncoder);
        // Component.leftWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
        // Component.rightWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
        // Chassis
        // Component.shifter = new SolenoidShifters(Port.Pneumatics.shifter.pcmID, Port.Pneumatics.shifter.forward,
        // Port.Pneumatics.shifter.reverse);
        // Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder, Component.rightWheelEncoder);
        // Component.chassis = new TankDriveShifting("2019-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
        Component.chassis = new TankDrive("2019-Chassis", Component.leftWheelA, Component.leftWheelB, Component.rightWheelA,
            Component.rightWheelB);
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
        // HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
        // HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.JOYSTICK_DEADZONE);
        // Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F, Component.rightWheelEncoder);
        // Component.drivePID.setAbsoluteTolerance(PID.Drive.tolerance);
        // Component.drivePID.setDerivativeTolerance(PID.Drive.dTolerance);
        Component.navx = new FusibleNavX(SerialPort.Port.kMXP);
        Component.alignmentCamera = new DummyCamera(0);
        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
        Component.driverXbox.setDeadZone(0.1);
        Component.leftMotorA = new Motor("LeftMotorA", new Spark(Port.CANMotor.leftMotorA, MotorType.kBrushed));
        Component.leftMotorB = new Motor("LeftMotorB", true, new Spark(Port.CANMotor.leftMotorB, MotorType.kBrushed));
        Component.rightMotorA = new Motor("RightMotorA", true, new Spark(Port.CANMotor.rightMotorA, MotorType.kBrushed));
        Component.rightMotorB = new Motor("rightMotorB", true, new Spark(Port.CANMotor.rightMotorB, MotorType.kBrushed));
        Component.chassis = new TankDrive("Chassis", Component.leftMotorA, Component.leftMotorB, Component.rightMotorA,
            Component.rightMotorB);
        for (Motor motor : Component.chassis.getMotors()) {
            LogKitten.wtf(motor== null);
        }
    }
}
