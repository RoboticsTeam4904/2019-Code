package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4904.standard.commands.Idle;
import org.usfirst.frc4904.standard.commands.Noop;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 Control elevator manually
 */
public class ElevatorSetSpeed extends RunIfElse {

	public ElevatorSetSpeed(CustomJoystick joystick) {
		super(
		new RunIf(new MotorControl(RobotMap.Component.elevator, joystick, CustomJoystick.Y_AXIS,
		Elevator.UP_SPEED),
		() -> {return RobotMap.Component.elevator.getPosition() < RobotMap.Component.elevator.MAX_POSITION || RobotMap.Component.elevator.isOverridden();}),
		new RunIf(new MotorControl(RobotMap.Component.elevator, joystick, CustomJoystick.Y_AXIS,
		Elevator.DOWN_SPEED),
		() -> {return RobotMap.Component.elevator.getPosition() > RobotMap.Component.elevator.MIN_POSITION || RobotMap.Component.elevator.isOverridden();}),
		() -> {
			return joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
		});
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
