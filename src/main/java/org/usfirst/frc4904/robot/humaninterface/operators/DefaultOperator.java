package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.VelcroPistonRetract;
import org.usfirst.frc4904.robot.commands.VelcroPistonExtend;
import org.usfirst.frc4904.robot.commands.CargoIntake;
import org.usfirst.frc4904.robot.commands.CargoOuttake;
import org.usfirst.frc4904.robot.commands.WristDown;
import org.usfirst.frc4904.robot.commands.WristUp;
import org.usfirst.frc4904.robot.commands.HatchRollerIntake;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.RunIfElse;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new HatchRollerIntake());
		RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new VelcroPistonExtend());
		RobotMap.HumanInput.Operator.joystick.button5.whenReleased(new VelcroPistonRetract());
		RobotMap.HumanInput.Operator.joystick.button2
			.onlyWhileHeld(new RunIfElse(new WristUp(), new WristDown(), RobotMap.Component.floorio.wrist::isExtended));
		RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new CargoIntake());
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new CargoOuttake());
	}
}