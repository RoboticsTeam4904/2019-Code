package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ElevatorSetSpeed;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.OverrideEnable;
import org.usfirst.frc4904.standard.commands.OverrideDisable;


public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new ElevatorSetSpeed());
		RobotMap.HumanInput.Operator.joystick.button2.onlyWhileHeld(new OverrideEnable(RobotMap.Component.elevator));
		RobotMap.HumanInput.Operator.joystick.button2.whenReleased(new OverrideDisable(RobotMap.Component.elevator));
	}
}