package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CANSensor;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {}
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {}
    }
    
    public static class Metrics{}
    public static class PID{
        public static class Drive{
            public static final double P = 0.00004904;
			public static final double I = 0.0000000004904;
			public static final double D = 0.4904;
			public static final double F = 0.00004904;
			public static final double tolerance = 4.904;
			public static final double dTolerance = 4.904;
        }
        public static class Turn{
            public static final double P = 0.00004904;
			public static final double I = 0.0000000004904;
			public static final double D = 0.4904;
			public static final double F = 0.00004904;
			public static final double tolerance = 4.904;
			public static final double dTolerance = 4.904;
        }
        public static class Elevator{
            public static final double P = 0.00004904;
			public static final double I = 0.0000000004904;
			public static final double D = 0.4904;
			public static final double F = 0.00004904;
			public static final double tolerance = 4.904;
			public static final double dTolerance = 4.904;
        }
    }
    public static class Component {
        public static CustomXbox driverXbox;
        public static TankDriveShifting chassis;
        public static CustomPIDController chassisTurnMC;
        public static CustomPIDController drivePID;
        public static NavX navx;
        public static EnableableModifier rightWheelAccelerationCap;
		public static EnableableModifier leftWheelAccelerationCap;
		public static CANEncoder leftWheelEncoder;
		public static CANEncoder rightWheelEncoder;
		public static EncoderPair chassisEncoders;
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
        Component.chassisTurnMC = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F, Component.navx);
        Component.chassisTurnMC.setMinimumNominalOutput(0.24);
		Component.chassisTurnMC.setInputRange(-180, 180);
		Component.chassisTurnMC.setContinuous(true);
		Component.chassisTurnMC.setAbsoluteTolerance(PID.Turn.tolerance);
        Component.chassisTurnMC.setDerivativeTolerance(PID.Turn.dTolerance);
        Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F,
        Component.rightWheelEncoder);
    }
}
