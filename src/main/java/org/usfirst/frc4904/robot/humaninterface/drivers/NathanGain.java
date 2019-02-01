package org.usfirst.frc4904.robot.humaninterface.drivers;
import org.usfirst.frc4904.robot.commands.PickupSolenoidExtend;
import org.usfirst.frc4904.robot.commands.PickupSolenoidRelease;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidExtend;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidRelease;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisShift;
import org.usfirst.frc4904.standard.humaninput.Driver;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;

public class NathanGain extends Driver {
	public static final double SPEED_GAIN = 1;
	public static final double SPEED_EXP = 2;
	public static final double TURN_GAIN = 1;
	public static final double TURN_EXP = 2;
	public static final double Y_SPEED_SCALE = 1;
	public static final double TURN_SPEED_SCALE = 1;

	public NathanGain() {
		super("NathanGain");

	}

	protected double scaleGain(double input, double gain, double exp) {
		return Math.pow(Math.abs(input), exp) * gain * Math.signum(input);
	}

	@Override
	public void bindCommands() {
		RobotMap.Component.driverXbox.a.whenPressed(new PickupSolenoidRelease());
		RobotMap.Component.driverXbox.b.whenPressed(new PickupSolenoidExtend());
		// RobotMap.Component.driverXbox.b.whenPressed(new PlaceSolenoidExtend());
		// RobotMap.Component.driverXbox.b.whenReleased(new PlaceSolenoidRelease());

		// RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new PickupSolenoidExtend());
		// RobotMap.HumanInput.Operator.joystick.button4.whenPressed(new PickupSolenoidRelease());
		// RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new PlaceSolenoidExtend());
		// RobotMap.HumanInput.Operator.joystick.button6.whenPressed(new PlaceSolenoidRelease());

		// RobotMap.Component.driverXbox.lb
		// 	.whenPressed(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.ShiftState.DOWN));
		// RobotMap.Component.driverXbox.rb
		// 	.whenPressed(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.ShiftState.UP));
    }
    @Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		double rawSpeed = RobotMap.Component.driverXbox.rt.getX() - RobotMap.Component.driverXbox.lt.getX();
		double speed = scaleGain(rawSpeed, NathanGain.SPEED_GAIN, NathanGain.SPEED_EXP)
			* NathanGain.Y_SPEED_SCALE;
		return speed;
	}

	@Override
	public double getTurnSpeed() {
		double rawTurnSpeed = RobotMap.Component.driverXbox.leftStick.getX();
		double turnSpeed = scaleGain(rawTurnSpeed, NathanGain.TURN_GAIN, NathanGain.TURN_EXP)
			* NathanGain.TURN_SPEED_SCALE;
		return turnSpeed;
	}
}