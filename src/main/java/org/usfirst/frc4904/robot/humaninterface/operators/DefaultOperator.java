package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.IndexerVelcroDown;
import org.usfirst.frc4904.robot.commands.IndexerVelcroHeld;
import org.usfirst.frc4904.robot.commands.IndexerVelcroRelease;
import org.usfirst.frc4904.robot.commands.IndexerVelcroUp;
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
		RobotMap.HumanInput.Operator.joystick.button1.whenPressed(new IndexerVelcroHeld());
		RobotMap.HumanInput.Operator.joystick.button2.whenPressed(new IndexerVelcroRelease());
		RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new IndexerVelcroUp());
		RobotMap.HumanInput.Operator.joystick.button4.whenPressed(new IndexerVelcroDown());


	}
}