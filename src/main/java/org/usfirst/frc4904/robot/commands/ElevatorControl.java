package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarLinkage;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

/**
 * Control elevator manually
 */
public class ElevatorControl extends RunIfElse {
	public ElevatorControl() {
		super(
			new RunIf(new MotorControl(RobotMap.Component.fourBar.elevator, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				FourBarLinkage.UP_SPEED),
				() -> {
					return RobotMap.Component.fourBar.getState().elevatorPosition < FourBarLinkage.MAX_POSITION
						|| RobotMap.Component.fourBar.isOverridden();
				}),
			new RunIf(new MotorControl(RobotMap.Component.fourBar.elevator, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				FourBarLinkage.DOWN_SPEED),
				() -> {
					return RobotMap.Component.fourBar.getState().elevatorPosition > FourBarLinkage.MIN_POSITION
						|| RobotMap.Component.fourBar.isOverridden();
				}),
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
