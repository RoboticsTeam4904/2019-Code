package org.usfirst.frc4904.robot.humaninterface.drivers;
import org.usfirst.frc4904.robot.commands.HatchIntake;
import org.usfirst.frc4904.robot.commands.HatchOutake;
import org.usfirst.frc4904.robot.commands.PickupSolenoidDown;
import org.usfirst.frc4904.robot.commands.PickupSolenoidUp;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidDown;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidUp;
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
		RobotMap.Component.driverXbox.a.whenPressed(new PickupSolenoidUp());
		RobotMap.Component.driverXbox.b.whenPressed(new PickupSolenoidDown());
		RobotMap.Component.driverXbox.x.onlyWhileHeld(new HatchIntake());
		RobotMap.Component.driverXbox.y.onlyWhileHeld(new HatchOutake());
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