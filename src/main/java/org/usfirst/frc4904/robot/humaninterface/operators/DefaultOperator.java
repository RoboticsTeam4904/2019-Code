package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.robot.commands.elevator.ElevatorControl;
import org.usfirst.frc4904.robot.commands.manipulator.ClawsDown;
import org.usfirst.frc4904.robot.commands.manipulator.ClawsUp;
import org.usfirst.frc4904.robot.commands.manipulator.HatchExtenderIn;
import org.usfirst.frc4904.robot.commands.manipulator.HatchExtenderOut;
import org.usfirst.frc4904.robot.commands.manipulator.HatchGrabberIn;
import org.usfirst.frc4904.robot.commands.manipulator.HatchGrabberOut;
import org.usfirst.frc4904.robot.commands.manipulator.RollerIn;
import org.usfirst.frc4904.robot.commands.manipulator.RollerOut;
import org.usfirst.frc4904.robot.commands.manipulator.HatchIntake;
import org.usfirst.frc4904.robot.commands.manipulator.HatchOuttake;
import org.usfirst.frc4904.robot.commands.manipulator.WristDown;
import org.usfirst.frc4904.robot.commands.manipulator.WristUp;
import org.usfirst.frc4904.robot.commands.manipulator.CargoIntake;
import org.usfirst.frc4904.robot.commands.manipulator.CargoOuttake;
import org.usfirst.frc4904.robot.commands.manipulator.LevelOneHatch;
import org.usfirst.frc4904.robot.commands.manipulator.ReadyGroundCargoIntake;
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
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new
		ElevatorControl(() -> {
		return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) >
		0;
		}));
		// RobotMap.HumanInput.Operator.joystick.button2.whenPressed(
		// new RunIfElse(new WristUp(), new WristDown(),
		// RobotMap.Component.floorio.wrist::isExtended));
		RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new RollerOut());
		RobotMap.HumanInput.Operator.joystick.button2.onlyWhileHeld(new RollerIn());

		// RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new HatchGrabberIn());//new HatchIntake());
		// RobotMap.HumanInput.Operator.joystick.button5.whenReleased(new HatchGrabberOut());


		// RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new HatchOuttake());
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new ReadyGroundCargoIntake());
		// RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new CargoOuttake()); 

		RobotMap.HumanInput.Operator.joystick.button12.whenPressed(new WristDown());
		RobotMap.HumanInput.Operator.joystick.button11.whenPressed(new WristUp());

		RobotMap.HumanInput.Operator.joystick.button7.whenPressed(new HatchExtenderOut());
		RobotMap.HumanInput.Operator.joystick.button8.whenPressed(new HatchExtenderIn());
		RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new LevelOneHatch());
		RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new ClawsDown());


		// RobotMap.HumanInput.Operator.joystick.button11.whenPressed(new WristUp());
		// RobotMap.HumanInput.Operator.joystick.button12.whenPressed(new WristDown());
		// RobotMap.HumanInput.Operator.joystick.button8
		// .whenPressed(new RunIfElse(new SolenoidRetract("FourBarUp",
		// RobotMap.Component.fourBar.lever),
		// new SolenoidExtend("FourBarDown", RobotMap.Component.fourBar.lever),
		// () -> {
		// boolean temp = RobotMap.Component.fourBar.lever.isExtended();
		// LogKitten.wtf(temp);
		// return temp;
		// }));
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
	}
}