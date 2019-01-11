package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.BaseLowered;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.robot.commands.BaseRaised;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Operator.joystick.button1.whenPressed(
			new BaseLowered());
		RobotMap.HumanInput.Operator.joystick.button2.whenPressed(
			new BaseRaised());
		
	}
}