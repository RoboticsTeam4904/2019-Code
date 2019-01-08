package org.usfirst.frc4904.standard.commands.chassis;


import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.ChassisController;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.subsystems.chassis.Chassis;
import edu.wpi.first.wpilibj.command.Command;

public class ChassisMoveDistance extends Command implements ChassisController {
	protected final ChassisMove chassisMove;
	protected final MotionController motionController;
	protected final Command fallbackCommand;
	protected final double distance;
	protected boolean runOnce;

	/**
	 * Constructor.
	 * This command moves the chassis forward a known distance via a set of encoders.
	 * The distance is calculated as the average of the provided encoders.
	 * The speed is decided by the provided motionController.
	 *
	 * @param chassis
	 * @param distance
	 *        distance to move in encoder ticks
	 * @param motionController
	 * @param fallbackCommand
	 *        If the sensor fails for some reason, this command will be cancelled, then the fallbackCommand will start
	 * @param encoders
	 */
	public ChassisMoveDistance(Chassis chassis, double distance, MotionController motionController, Command fallbackCommand) {
		chassisMove = new ChassisMove(chassis, this, false);
		this.motionController = motionController;
		this.distance = distance;
		this.fallbackCommand = fallbackCommand;
		runOnce = false;
	}

	/**
	 * Constructor.
	 * This command moves the chassis forward a known distance via a set of encoders.
	 * The distance is calculated as the average of the provided encoders.
	 * The speed is decided by the provided motionController.
	 *
	 * @param chassis
	 * @param distance
	 *        distance to move in encoder ticks
	 * @param motionController
	 * @param encoders
	 */
	public ChassisMoveDistance(Chassis chassis, double distance, MotionController motionController) {
		this(chassis, distance, motionController, null);
	}

	@Override
	public void initialize() {
		chassisMove.start();
		try {
			motionController.resetSafely();
		}
		catch (InvalidSensorException e) {
			LogKitten.w("Cancelling ChassisMoveDistance");
			chassisMove.cancel();
			cancel();
			if (fallbackCommand != null) {
				fallbackCommand.start();
			}
			return;
		}
		motionController.setSetpoint(motionController.getSensorValue() + distance);
		motionController.enable();
	}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		double speed;
		try {
			speed = motionController.getSafely();
		}
		catch (InvalidSensorException e) {
			LogKitten.w("Cancelling ChassisMoveDistance");
			chassisMove.cancel();
			cancel();
			if (fallbackCommand != null) {
				fallbackCommand.start();
			}
			speed = 0;
		}
		LogKitten.d("MotionProfileSpeed: " + speed);
		return speed;
	}

	@Override
	public double getTurnSpeed() {
		return 0;
	}

	@Override
	protected void end() {
		chassisMove.cancel();
		motionController.disable();
		motionController.reset();
		runOnce = false;
	}

	@Override
	protected void execute() {}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		if (chassisMove.isRunning() && !runOnce) {
			runOnce = true;
		}
		return (motionController.onTarget() || !chassisMove.isRunning()) && runOnce;
	}
}
