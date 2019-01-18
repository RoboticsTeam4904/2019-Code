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


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {
            public static final int elevMotor1 = 1; // not final numbers
            public static final int elevMotor2 = 2;
        }
        public static class PWM {}
        public static class CAN {
            public static final int elevCANEncoder = 1; // also not final #
        }
        public static class Pneumatics {
            public static final PCMPort fourBarLever = new PCMPort(0, 7, 6);
        }
    }
    
    public static class Metrics{}
    public static class PID{
        public static class Elevator {
            public static final double P = 1; // ALSO not final number
            public static final double I = 1;
            public static final double D = 1;
            public static final double F = 1;
        }
    }
    public static class Component {
        public static CustomXbox driverXbox;

        public static Elevator elevator;
        public static CANTalonSRX elevMotor1;
        public static CANTalonSRX elevMotor2;
        public static CANEncoder elevCANEncoder;
        public static CustomPIDController elevPID;
        public static FourBarLinkage fourBar;
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
        
        Component.elevMotor1 = new CANTalonSRX(Port.CANMotor.elevMotor1);
        Component.elevMotor2 = new CANTalonSRX(Port.CANMotor.elevMotor2);
        Component.elevCANEncoder = new CANEncoder(Port.CAN.elevCANEncoder);
        Component.elevCANEncoder.setDistancePerPulse(Elevator.TICK_MULTIPLIER);
        Component.elevPID = new CustomPIDController(PID.Elevator.P, PID.Elevator.I, PID.Elevator.D, PID.Elevator.F, Component.elevCANEncoder);
        Component.elevator = new Elevator(Component.elevPID, Component.elevCANEncoder, Component.elevMotor1, Component.elevMotor2);
        Component.fourBar = new FourBarLinkage(Port.Pneumatics.fourBarLever.buildDoubleSolenoid());

    }

    public static class PCMPort {
		public int pcmID;
		public int forward;
		public int reverse;

		/**
		 * Defines a piston based on two ports and a PCM number
		 * 
		 * @param pcmID
		 *        The ID of the PCM attached to the piston. Usually 0 or 1.
		 * @param forward
		 *        The forward port of the piston.
		 * @param reverse
		 *        The reverse port of the piston.
		 */
		public PCMPort(int pcmID, int forward, int reverse) { // First variable PCM number, second forward, third reverse.
			this.pcmID = pcmID;
			this.forward = forward;
			this.reverse = reverse;
		}

		public DoubleSolenoid buildDoubleSolenoid() {
			return new DoubleSolenoid(pcmID, forward, reverse);
		}
	}
}
