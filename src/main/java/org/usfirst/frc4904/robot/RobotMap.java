package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.robot.humaninterface.HumanInterfaceConfig;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.custom.PCMPort;
//import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
//import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.NavX;



public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;

        }
        public static class CANMotor {}
        public static class PWM {
            public static final int leftDriveA = -1; // TODO: Change ports
			public static final int leftDriveB = -1;
			public static final int rightDriveA = -1;
			public static final int rightDriveB = -1;
        }
        public static class CAN {
            //public static final int leftEncoder = -1; // TODO: Change ports
			//public static final int rightEncoder = -1;
        }
        public static class Pneumatics {
            public static final PCMPort shifter = new PCMPort(-1, -1, -1); // TODO: Change ports
        }
    }
    
    public static class Metrics{
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
		public static class Robot {
			public static final double ROBOT_WIDTH = 28;
		}
    }
    public static class PID {
		public static class Drive {
			public static final double P = 0.04; //Tune PID
			public static final double I = 0.0; //Tune PID
			public static final double D = -0.006; //Tune PID
			public static final double F = 0.01; //Tune PID
			public static final double tolerance = 4.5; //Tune PID
			public static final double dTolerance = 3.0; //Tune PID
        }
    }
    public static class Component {
        public static PDP pdp;

        public static TankDriveShifting chassis;
		public static Motor leftWheel;
		public static Motor rightWheel;
        public static SolenoidShifters shifter;
        public static EnableableModifier rightWheelAccelerationCap;
        public static EnableableModifier leftWheelAccelerationCap;
        
		//public static CANEncoder leftWheelEncoder;
		//public static CANEncoder rightWheelEncoder;
		//public static EncoderPair chassisEncoders;
        public static CustomPIDController chassisTurnMC;
		public static CustomPIDController drivePID;
		public static NavX navx;
	}
	
	public static class NetworkTables {
		public static NetworkTableInstance inst;
		public static NetworkTable table;

		public static class Sensors {
			public static NetworkTable table;
			public static NetworkTableEntry betaRF;
			public static NetworkTableEntry betaFloor;
			public static NetworkTableEntry theta;
			public static NetworkTableEntry x;
			public static NetworkTableEntry y;
			public static NetworkTableEntry distance;
			public static NetworkTableEntry isRFTapeVisible;
			public static NetworkTableEntry isFloorTapeVisible;
		}
		
		public static class PID {
			public static NetworkTable table;

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
	
	public static class UpdateableData {
		public static double betaRF;
		public static double betaFloor;
		public static double theta;
		public static double x;
		public static double y;
		public static double distance;
		public static double isRFTapeVisible;
		public static double isFloorTapeVisible;
		public static class Update extends Command {
			public Update() {}

			@Override
			protected void initialize() {
				betaRF = RobotMap.NetworkTables.Sensors.betaRF.getDouble(0);
				betaFloor = RobotMap.NetworkTables.Sensors.betaFloor.getDouble(0);
				theta = RobotMap.NetworkTables.Sensors.theta.getDouble(0);
				x = RobotMap.NetworkTables.Sensors.x.getDouble(0);
				y = RobotMap.NetworkTables.Sensors.y.getDouble(0);
				distance = RobotMap.NetworkTables.Sensors.distance.getDouble(0);
				isRFTapeVisible = RobotMap.NetworkTables.Sensors.isRFTapeVisible.getDouble(0);
				isFloorTapeVisible = RobotMap.NetworkTables.Sensors.isRFTapeVisible.getDouble(0);
			}
			protected boolean isFinished() {
				return true;
			}
		}
		public static final DoubleSupplier getBetaRF = () -> betaRF;
		public static final DoubleSupplier getBetaFloor = () -> betaFloor;
		public static final DoubleSupplier getTheta = () -> theta;
		public static final DoubleSupplier getX = () -> x;
		public static final DoubleSupplier getY = () -> y;
		public static final DoubleSupplier getDistance = () -> distance;
		public static final DoubleSupplier getIsRFTapeVisible = () -> isRFTapeVisible;
		public static final DoubleSupplier getIsFloorTapeVisible = () -> isFloorTapeVisible;
	}

    public RobotMap() {
        Component.pdp = new PDP();

        // Wheels
        // Component.leftWheelEncoder = new CANEncoder("LeftEncoder", Port.CAN.leftEncoder);
        // Component.rightWheelEncoder = new CANEncoder("RightEncoder", Port.CAN.rightEncoder);
        // Component.leftWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
        // Component.rightWheelEncoder.setDistancePerPulse(Metrics.Wheel.INCHES_PER_TICK);
		Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.leftWheelAccelerationCap.enable();
		Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
		Component.rightWheelAccelerationCap.enable();
        Component.leftWheel = new Motor("LeftWheel", Component.leftWheelAccelerationCap,
			new CANTalonSRX(Port.PWM.leftDriveA), new CANTalonSRX(Port.PWM.leftDriveB));
		Component.rightWheel = new Motor("RightWheel", Component.rightWheelAccelerationCap,
			new CANTalonSRX(Port.PWM.rightDriveA), new CANTalonSRX(Port.PWM.rightDriveB));
		
		NetworkTables.inst = NetworkTableInstance.getDefault();
		NetworkTables.Sensors.table = NetworkTables.inst.getTable("Sensors");
		NetworkTables.Sensors.betaRF = NetworkTables.Sensors.table.getEntry("RF Beta");
		NetworkTables.Sensors.betaFloor = NetworkTables.Sensors.table.getEntry("Floor Beta");
		NetworkTables.Sensors.theta = NetworkTables.Sensors.table.getEntry("Theta");
		NetworkTables.Sensors.x = NetworkTables.Sensors.table.getEntry("X");
		NetworkTables.Sensors.y = NetworkTables.Sensors.table.getEntry("Y");
		NetworkTables.Sensors.distance = NetworkTables.Sensors.table.getEntry("Distance");
		NetworkTables.Sensors.isRFTapeVisible = NetworkTables.Sensors.table.getEntry("Is RF Tape Visible?");
		NetworkTables.Sensors.isFloorTapeVisible = NetworkTables.Sensors.table.getEntry("Is Floor Tape Visible?");
		
		// Chassis
		Component.shifter = new SolenoidShifters(Port.Pneumatics.shifter.pcmID, Port.Pneumatics.shifter.forward,
            Port.Pneumatics.shifter.reverse);
        //Component.chassisEncoders = new EncoderPair(Component.leftWheelEncoder, Component.rightWheelEncoder);
        Component.chassis = new TankDriveShifting("2019-Chassis", Component.leftWheel, Component.rightWheel, Component.shifter);
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Driver.xbox.setDeadZone(HumanInterfaceConfig.XBOX_DEADZONE);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
        HumanInput.Operator.joystick.setDeadzone(HumanInterfaceConfig.JOYSTICK_DEADZONE);
        //Component.drivePID = new CustomPIDController(PID.Drive.P, PID.Drive.I, PID.Drive.D, PID.Drive.F, Component.rightWheelEncoder);
		Component.drivePID.setAbsoluteTolerance(PID.Drive.tolerance);
		Component.drivePID.setDerivativeTolerance(PID.Drive.dTolerance);
    }
}
