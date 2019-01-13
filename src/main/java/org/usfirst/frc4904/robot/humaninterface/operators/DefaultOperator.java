package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.PusherFireRetract;
import org.usfirst.frc4904.robot.commands.ProngExpand;
import org.usfirst.frc4904.robot.commands.ProngContract;
import org.usfirst.frc4904.standard.humaninput.Operator;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new PusherFireRetract());
		RobotMap.HumanInput.Operator.joystick.button2.onlyWhileHeld(new ProngExpand());
		RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new ProngContract());

	}
}