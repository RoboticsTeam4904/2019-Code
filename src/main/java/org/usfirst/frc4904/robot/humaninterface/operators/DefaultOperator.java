package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.robot.subsystems.Elevator;


public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {

		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new RunIfElse(
            new MotorControl(RobotMap.Component.elevator, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
                Elevator.UP_SPEED),
            new MotorControl(RobotMap.Component.elevator, RobotMap.HumanInput.Operator.joystick, CustomJoystick.Y_AXIS,
                Elevator.DOWN_SPEED),
            () -> {
                return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
            }));

	}
}