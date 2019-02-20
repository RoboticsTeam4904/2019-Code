package org.usfirst.frc4904.robot.commands;

import java.util.function.BooleanSupplier;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

/**
 * Control elevator manually
 */
public class ElevatorControl extends RunIf {
	public ElevatorControl(BooleanSupplier joystickDirection) {
		super(new MotorControl(RobotMap.Component.fourBar.elevator, RobotMap.HumanInput.Operator.joystick,
				CustomJoystick.Y_AXIS,
				joystickDirection.getAsBoolean() ? FourBarElevator.UP_SPEED : FourBarElevator.DOWN_SPEED), () -> {
					if (joystickDirection.getAsBoolean()) {
						return !RobotMap.Input.elevatorSwitchTop.get() || RobotMap.Component.fourBar.isOverridden();
					} else {
						return !RobotMap.Input.elevatorSwitchBottom.get() || RobotMap.Component.fourBar.isOverridden();

					}
				});
		requires(RobotMap.Component.fourBar.elevator);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
