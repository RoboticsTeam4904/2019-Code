package org.usfirst.frc4904.robot.commands.elevator;


import java.awt.Robot;
import java.util.function.BooleanSupplier;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

/**
 * Control elevator manually
 */
public class ElevatorControl extends MotorControl {
	private BooleanSupplier joystickDirection;

	public ElevatorControl(BooleanSupplier joystickDirection) {
		super(RobotMap.Component.fourBar.elevator, RobotMap.HumanInput.Operator.joystick,
			CustomJoystick.Y_AXIS);
		requires(RobotMap.Component.fourBar.elevator);
		this.joystickDirection = joystickDirection;
	}

	@Override
	protected void execute() {
		if (!RobotMap.Component.fourBar.isOverridden()
			&& (joystickDirection.getAsBoolean() ? RobotMap.Input.elevatorSwitchTop : RobotMap.Input.elevatorSwitchBottom)
				.get()) {
			motor.set(0);
			LogKitten.d("MotorControl executing: 0");
		} else {
			double speed = controller.getAxis(axis)
				* (joystickDirection.getAsBoolean() ? FourBarElevator.UP_SPEED : FourBarElevator.DOWN_SPEED);
			motor.set(speed);
			LogKitten.d("MotorControl executing: " + speed);
		}
	}
}
