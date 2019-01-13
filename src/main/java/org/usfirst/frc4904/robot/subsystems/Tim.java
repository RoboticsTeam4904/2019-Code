package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CustomEncoder;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.LinearModifier;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.SpeedModifierGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4904.robot.commands.TimUp;


/**
 *
 */
public class Tim extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public enum TimState {
		FULL_UP(75), FULL_DOWN(1740);
		public final double position;
		
		private TimState(double position) {
			this.position = position;
		}
	} 

	public final Motor intakeMotor; //spinny spin
	public final PositionSensorMotor rotateMotor; //perhaps a position encoded motor
	public final Motor indexMotor;  //spinny spin

	public final CustomEncoder encoder;

	public final Util.Range range;
	public Tim(MotionController motionController, CustomEncoder encoder, SpeedController intakeMotor, MotionController rotateMotor, SpeedController indexMotor, SpeedController... motors)  {
		this.intakeMotor = new Motor("Tim Intake Motor", intakeMotor);
		this.intakeMotor.setInverted(true);

		this.rotateMotor = new PositionSensorMotor("Tim Rotate Motor", rotateMotor);
		this.encoder=encoder;

		this.indexMotor = new Motor("Tim Index Motor", indexMotor);
		
		this.range = new Util.Range(TimState.FULL_UP.position, TimState.FULL_DOWN.position);

	}

	public void setPosition(){

	}
	public void initDefaultCommand() {
		setDefaultCommand(new TimUp());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	

}