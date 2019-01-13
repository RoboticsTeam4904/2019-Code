package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 * CargoIO is the subsystem of rollers
 * in the front of the robot, allowing
 * it to intake/outtake cargo in front
 * of it.
 */
public class CargoIO {
	public static final double INTAKE_SPEED = 0.5;
	public static final double OUTTAKE_SPEED = -0.5;
	public final Motor rollerTop;
	public final Motor rollerBottom;

	/**
	 * Create a new CargoIO instance.
	 * 
	 * @param rollerLeft
	 *        The motor object corresponding
	 *        to the left motors for intaking
	 *        and outtaking cubes.
	 * @param rollerRight
	 *        The motor object corresponding
	 *        to the right motors for intaking
	 *        and outtaking cubes.
	 */
	public CargoIO(Motor rollerTop, Motor rollerBottom) {
		this.rollerTop = rollerTop;
		this.rollerBottom = rollerBottom;
	}

}
