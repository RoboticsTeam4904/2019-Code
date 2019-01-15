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
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


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
            public static final double P = 0.01;
			public static final double I = 0.001;
			public static final double D = 0.01;
            public static final double F = 0.01;
            public static double e = RobotMap.Component.drivePID.getError();
			public static final double tolerance = 4.904;
			public static final double dTolerance = 4.904;
        }
        public static class Turn{
            public static final double P = 0.01;
			public static final double I = 0.001;
			public static final double D = 0.01;
            public static final double F = 0.01;
            public static double e = RobotMap.Component.turnPID.getError();
			public static final double tolerance = 4.904;
			public static final double dTolerance = 4.904;
        }
        public static class Elevator{
            public static final double P = 0.01;
			public static final double I = 0.001;
			public static final double D = 0.01;
            public static final double F = 0.01;
            public static double e = RobotMap.Component.elevPID.getError();
			public static final double tolerance = 4.904;
			public static final double dTolerance = 4.904;
        }
    }
    public static class Component {
        public static CustomXbox driverXbox;
        public static TankDriveShifting chassis;
        public static CustomPIDController chassisTurnMC;
        public static CustomPIDController drivePID;
        public static CustomPIDController turnPID;
        public static CustomPIDController elevPID;
        public static NavX navx;
        public static EnableableModifier rightWheelAccelerationCap;
		public static EnableableModifier leftWheelAccelerationCap;
		public static CANEncoder leftWheelEncoder;
		public static CANEncoder rightWheelEncoder;
		public static EncoderPair chassisEncoders;
    }
    public static class NetworkTables {
		public static NetworkTableInstance inst;
		public static NetworkTable table;

		public static class Sensors {
            public static NetworkTable table;
			public static NetworkTableEntry yawEntry;
			public static NetworkTableEntry rightEncoderEntry;
			public static NetworkTableEntry leftEncoderEntry;
			public static NetworkTableEntry accelXEntry;
			public static NetworkTableEntry accelYEntry;
            public static NetworkTableEntry accelZEntry;
        }
        
        public static class PID {
            public static NetworkTable table;
            public static NetworkTableEntry driveP;
            public static NetworkTableEntry driveI;
            public static NetworkTableEntry driveD;
            public static NetworkTableEntry driveF;
            public static NetworkTableEntry driveError;
            public static NetworkTableEntry turnP;
            public static NetworkTableEntry turnI;
            public static NetworkTableEntry turnD;
            public static NetworkTableEntry turnF;
            public static NetworkTableEntry turnError;
            public static NetworkTableEntry elevP;
            public static NetworkTableEntry elevI;
            public static NetworkTableEntry elevD;
            public static NetworkTableEntry elevF;
            public static NetworkTableEntry elevError;
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
        Component.driverXbox.setDeadZone(0.1);
        Component.chassisTurnMC = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F, Component.navx);
        // Component.chassisTurnMC.setMinimumNominalOutput(0.24);
		// Component.chassisTurnMC.setInputRange(-180, 180);
		// Component.chassisTurnMC.setContinuous(true);
		Component.chassisTurnMC.setAbsoluteTolerance(PID.Turn.tolerance);
        Component.chassisTurnMC.setDerivativeTolerance(PID.Turn.dTolerance);
        Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F,
        Component.rightWheelEncoder);
        // Network Tables
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.PID.table = NetworkTables.inst.getTable("PID");
        NetworkTables.PID.driveP = NetworkTables.PID.table.getEntry("driveP");
        NetworkTables.PID.driveI = NetworkTables.PID.table.getEntry("driveI");
        NetworkTables.PID.driveD = NetworkTables.PID.table.getEntry("driveD");
        NetworkTables.PID.driveF = NetworkTables.PID.table.getEntry("driveF");
        NetworkTables.PID.driveError = NetworkTables.PID.table.getEntry("driveError");
        NetworkTables.PID.turnP = NetworkTables.PID.table.getEntry("turnP");
        NetworkTables.PID.turnI = NetworkTables.PID.table.getEntry("turnI");
        NetworkTables.PID.turnD = NetworkTables.PID.table.getEntry("turnD");
        NetworkTables.PID.turnF = NetworkTables.PID.table.getEntry("turnF");
        NetworkTables.PID.turnError = NetworkTables.PID.table.getEntry("turnError");
        NetworkTables.PID.elevP = NetworkTables.PID.table.getEntry("elevP");
        NetworkTables.PID.elevI = NetworkTables.PID.table.getEntry("elevI");
        NetworkTables.PID.elevD = NetworkTables.PID.table.getEntry("elevD");
        NetworkTables.PID.elevF = NetworkTables.PID.table.getEntry("elevF");
        NetworkTables.PID.elevError = NetworkTables.PID.table.getEntry("elevError");

		// NetworkTables.Sensors.yawEntry = NetworkTables.Sensors.table.getEntry("yaw");
		// NetworkTables.Sensors.rightEncoderEntry = NetworkTables.Sensors.table.getEntry("rightEncoder");
		// NetworkTables.Sensors.leftEncoderEntry = NetworkTables.Sensors.table.getEntry("leftEncoder");
		// NetworkTables.Sensors.accelXEntry = NetworkTables.Sensors.table.getEntry("accelX");
		// NetworkTables.Sensors.accelYEntry = NetworkTables.Sensors.table.getEntry("accelY");
		// NetworkTables.Sensors.accelZEntry = NetworkTables.Sensors.table.getEntry("accelZ");
    }
}
