package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.manipulator.NikhilDefault;
import org.usfirst.frc4904.robot.commands.manipulator.Nikhil2;
import org.usfirst.frc4904.robot.commands.manipulator.Nikhil3;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorControl;
import org.usfirst.frc4904.robot.commands.manipulator.GroundIntake;
import org.usfirst.frc4904.robot.commands.manipulator.GroundToHatch;
import org.usfirst.frc4904.robot.commands.manipulator.ReadyGroundIntake;
import org.usfirst.frc4904.standard.commands.OverrideEnable;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
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
		// RobotMap.HumanInput.Operator.joystick.button1.whenPressed(new NikhilDefault());
		// RobotMap.HumanInput.Operator.joystick.button2.whenPressed(new Nikhil2());
		// RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new Nikhil3());

		//RobotMap.HumanInput.Operator.joystick.buttonX.whenPressed(new GroundIntake());
		//RobotMap.HumanInput.Operator.joystick.buttonY.whenPressed(new HatchIntake());
		//RobotMap.HumanInput.Operator.joystick.buttonZ.whenPressed(new ReadyGroundIntake());
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new ElevatorControl(() -> {
			return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;
		}));
		RobotMap.HumanInput.Operator.joystick.button8
				.whenPressed(new RunIfElse(new SolenoidExtend("FourBarUp", RobotMap.Component.fourBar.lever),
						new SolenoidRetract("FourBarDown", RobotMap.Component.fourBar.lever),
						RobotMap.Component.fourBar.lever::isExtended));
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new OverrideEnable(RobotMap.Component.fourBar));
		RobotMap.HumanInput.Operator.joystick.button9.whenReleased(new OverrideDisable(RobotMap.Component.fourBar));


	}
}