package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.PickupSolenoidDown;
import org.usfirst.frc4904.robot.commands.PickupSolenoidUp;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidDown;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidUp;
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
		 RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new PickupSolenoidDown());
		 RobotMap.HumanInput.Operator.joystick.button4.whenPressed(new PickupSolenoidUp());
		 RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new PlaceSolenoidDown());
		 RobotMap.HumanInput.Operator.joystick.button6.whenPressed(new PlaceSolenoidUp());


	}
}