package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Elevator;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

/**
 * Control elevator manually
 */
public class ElevatorSetSpeed extends RunIfElse {
	public ElevatorSetSpeed() {
		super(
			new RunIf(new MotorControl(RobotMap.Component.elevator, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Elevator.UP_SPEED),
				() -> {
					return RobotMap.Component.elevator.getPosition() < Elevator.MAX_POSITION
						|| RobotMap.Component.elevator.isOverridden();
				}),
			new RunIf(new MotorControl(RobotMap.Component.elevator, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
				Elevator.DOWN_SPEED),
				() -> {
					return RobotMap.Component.elevator.getPosition() > Elevator.MIN_POSITION
						|| RobotMap.Component.elevator.isOverridden();
				}),
			() -> {
				return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
			});
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
