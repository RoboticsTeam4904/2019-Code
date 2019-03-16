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
import org.usfirst.frc4904.robot.subsystems.Manipulator;
import org.usfirst.frc4904.robot.commands.manipulator.CargoIntake;
import org.usfirst.frc4904.robot.commands.manipulator.CargoOuttake;
import org.usfirst.frc4904.standard.commands.OverrideEnable;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.OverrideDisable;

public class TestOperator extends Operator {
	public TestOperator() {
		super("TestOperator");
	}

	public TestOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		// Elevator		6-Activate	Joystick-Control
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new
			ElevatorControl(() -> {return RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0;}));
		// Roller			1-Out	2-In
		RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new MotorConstant("RollersOut", RobotMap.Component.manipulator.roller, Manipulator.OUTTAKE_SPEED)); //RollerOut());
		RobotMap.HumanInput.Operator.joystick.button2.onlyWhileHeld(new MotorConstant("RollersIn", RobotMap.Component.manipulator.roller, Manipulator.INTAKE_SPEED)); // RollerIn();
		// Claws			3-Down	5-Up
		RobotMap.HumanInput.Operator.joystick.button3.whenPressed(new SolenoidExtend("ClawsDown", RobotMap.Component.manipulator.claws)); // ClawsDown());
		RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new SolenoidRetract("ClawsUp", RobotMap.Component.manipulator.claws)); // ClawsUp());
		// HatchGrabber		4-In	6-Out
		RobotMap.HumanInput.Operator.joystick.button4.whenPressed(new SolenoidRetract("HatchGrabberIn", RobotMap.Component.manipulator.hatchGrabber)); // HatchGrabberIn());
		RobotMap.HumanInput.Operator.joystick.button6.whenPressed(new SolenoidExtend("HatchGrabberOut", RobotMap.Component.manipulator.hatchGrabber)); // HatchGrabberOut());
		// HatchExtender	7-Out	8-In
		RobotMap.HumanInput.Operator.joystick.button7.whenPressed(new SolenoidExtend("HatchExtenderOut", RobotMap.Component.manipulator.hatchExtender)); // HatchExtenderOut());
		RobotMap.HumanInput.Operator.joystick.button8.whenPressed(new SolenoidRetract("HatchExtenderIn", RobotMap.Component.manipulator.hatchExtender)); // HatchExtenderIn());
		// FourBar			9-Up	10-Down
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new SolenoidExtend("FourBarUp", RobotMap.Component.fourBar.lever));
		RobotMap.HumanInput.Operator.joystick.button10.whenPressed(new SolenoidRetract("FourBarDown", RobotMap.Component.fourBar.lever));
		// Wrist			11-Up	12-Down
		RobotMap.HumanInput.Operator.joystick.button11.whenPressed(new SolenoidRetract("WristUp", RobotMap.Component.manipulator.wrist)); // WristUp());
		RobotMap.HumanInput.Operator.joystick.button12.whenPressed(new SolenoidExtend("WristDown", RobotMap.Component.manipulator.wrist));  // WristDown());
	}
}