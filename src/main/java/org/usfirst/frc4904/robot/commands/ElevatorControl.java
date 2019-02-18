package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 * Control elevator manually
 */
public class ElevatorControl extends RunIfElse {
	public ElevatorControl() {
		super(
			new MotorControl(RobotMap.Component.fourBar.elevator, RobotMap.HumanInput.Operator.joystick,
				CustomJoystick.Y_AXIS,
				FourBarElevator.UP_SPEED),
			new MotorControl(RobotMap.Component.fourBar.elevator, RobotMap.HumanInput.Operator.joystick,
				CustomJoystick.Y_AXIS,
				FourBarElevator.DOWN_SPEED),
			() -> {
				return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
			});
		requires(RobotMap.Component.fourBar.elevator);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
