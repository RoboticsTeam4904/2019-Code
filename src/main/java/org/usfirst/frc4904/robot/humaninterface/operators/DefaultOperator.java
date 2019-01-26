package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlipperDown;
import org.usfirst.frc4904.robot.commands.FlipperUp;
import org.usfirst.frc4904.standard.humaninput.Operator;


public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
	
		super(name);
	}

	@Override
	public void bindCommands() { // TODO: Add VelcroPlate routines to button1 and button2.
		RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new FlipperUp());
		RobotMap.HumanInput.Operator.joystick.button4.whenPressed(new FlipperDown());


	}
}