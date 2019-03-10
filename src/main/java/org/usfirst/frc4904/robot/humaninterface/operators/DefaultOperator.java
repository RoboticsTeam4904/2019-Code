package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorControl;
import org.usfirst.frc4904.robot.commands.manipulator.ClawsDown;
import org.usfirst.frc4904.robot.commands.manipulator.ClawsUp;
import org.usfirst.frc4904.robot.commands.manipulator.ReadyGroundIntake;
import org.usfirst.frc4904.robot.commands.manipulator.RollerIn;
import org.usfirst.frc4904.robot.commands.manipulator.RollerOut;
import org.usfirst.frc4904.robot.commands.manipulator.WristDown;
import org.usfirst.frc4904.robot.commands.manipulator.WristUp;
import org.usfirst.frc4904.standard.commands.OverrideEnable;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.LogKitten;
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
		// RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new
		// ElevatorControl(() -> {
		// return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) >
		// 0;
		// }));
		// RobotMap.HumanInput.Operator.joystick.button2.whenPressed(
		// new RunIfElse(new WristUp(), new WristDown(),
		// RobotMap.Component.floorio.wrist::isExtended));
		// RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new
		// HatchRollerIntake());
		// RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new
		// CargoIntake());
		// RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new
		// VelcroPistonExtend());
		// RobotMap.HumanInput.Operator.joystick.button5.whenReleased(new
		// VelcroPistonRetract());
		// RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new
		// CargoOuttake());
		// RobotMap.HumanInput.Operator.joystick.button7.onlyWhileHeld(new
		// HatchRollerOuttake());
		RobotMap.HumanInput.Operator.joystick.button2.onlyWhileHeld(
			new MotorConstant(RobotMap.Component.manipulator.roller, RobotMap.Component.manipulator.INTAKE_SPEED));
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(
			new MotorConstant(RobotMap.Component.manipulator.roller, RobotMap.Component.manipulator.OUTTAKE_SPEED));
		RobotMap.HumanInput.Operator.joystick.button11.whenPressed(new WristUp());
		RobotMap.HumanInput.Operator.joystick.button12.whenPressed(new WristDown());
		RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new ClawsUp());
		RobotMap.HumanInput.Operator.joystick.button6.whenPressed(new ClawsDown());
		RobotMap.HumanInput.Operator.joystick.button8
			.whenPressed(new RunIfElse(new SolenoidRetract("FourBarUp",
				RobotMap.Component.fourBar.lever),
				new SolenoidExtend("FourBarDown", RobotMap.Component.fourBar.lever),
				() -> {
					boolean temp = RobotMap.Component.fourBar.lever.isExtended();
					LogKitten.wtf(temp);
					return temp;
				}));
		RobotMap.HumanInput.Operator.joystick.button9
			.whenPressed(new SolenoidExtend("FourBarUp",
				RobotMap.Component.fourBar.lever));
		RobotMap.HumanInput.Operator.joystick.button10
			.whenPressed(new SolenoidRetract("FourBarDown",
				RobotMap.Component.fourBar.lever));
		// RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new
		// OverrideEnable(RobotMap.Component.fourBar));
		// RobotMap.HumanInput.Operator.joystick.button9.whenReleased(new
		// OverrideDisable(RobotMap.Component.fourBar));
		// RobotMap.HumanInput.Operator.joystick.button10.whenPressed(new
		// HatchOuttakeExtend());
		// RobotMap.HumanInput.Operator.joystick.button10.whenReleased(new
		// HatchOuttakeRetract());
	}
}