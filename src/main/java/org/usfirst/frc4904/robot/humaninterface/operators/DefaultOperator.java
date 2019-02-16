package org.usfirst.frc4904.robot.humaninterface.operators;


import java.util.function.BooleanSupplier;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ElevatorControl;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.OverrideEnable;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
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
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new ElevatorControl());
		RobotMap.HumanInput.Operator.joystick.button2.whenPressed(new OverrideEnable(RobotMap.Component.fourBar));
		RobotMap.HumanInput.Operator.joystick.button2.whenReleased(new OverrideDisable(RobotMap.Component.fourBar));
		RobotMap.HumanInput.Operator.joystick.button3
			.whenPressed(new RunIfElse(new SolenoidExtend("FourBarUp", RobotMap.Component.fourBar.lever),
				new SolenoidRetract("FourBarDown", RobotMap.Component.fourBar.lever), () -> {
					return !RobotMap.Component.fourBar.lever.isExtended();
				}));
	}
}