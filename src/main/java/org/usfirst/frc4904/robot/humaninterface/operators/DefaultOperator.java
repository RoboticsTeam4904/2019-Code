package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.NikhilDefault;
import org.usfirst.frc4904.robot.commands.Nikhil2;
import org.usfirst.frc4904.robot.commands.Nikhil3;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
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
		RobotMap.HumanInput.Operator.joystick.button1.whenPressed(new NikhilDefault());
		RobotMap.HumanInput.Operator.joystick.button2.whenPressed(new Nikhil2());
		RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new Nikhil3());
	}
}