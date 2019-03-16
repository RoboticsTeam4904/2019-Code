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
import org.usfirst.frc4904.standard.commands.OverrideEnable;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.OverrideDisable;

public class FancyOperator extends Operator {
	public FancyOperator() {
		super("FancyOperator");
	}

	public FancyOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		// Elevator		6-Activate	Joystick-Control
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(
			new ElevatorControl(() -> RobotMap.HumanInput.Operator.joystick.getAxis(CustomJoystick.Y_AXIS) > 0));
		// Roller			1-Out	2-In
		// RobotMap.HumanInput.Operator.joystick.button1.onlyWhileHeld(new RollerOut());
		// RobotMap.HumanInput.Operator.joystick.button2.onlyWhileHeld(new RollerIn());
		// Hatch	3-Intake	5-Outtake
		RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new HatchIntake());
		RobotMap.HumanInput.Operator.joystick.button6.whenPressed(new HatchOuttake());
		// Cargo	4-Intake	6-Outtake
		RobotMap.HumanInput.Operator.joystick.button4.onlyWhileHeld(new CargoIntake());
		RobotMap.HumanInput.Operator.joystick.button6.onlyWhileHeld(new CargoOuttake());
		// HatchExtender	7-Out	8-In
		// RobotMap.HumanInput.Operator.joystick.button7.whenPressed(new SolenoidExtend(RobotMap.Component.manipulator.hatchExtender)); //HatchExtenderOut());
		// RobotMap.HumanInput.Operator.joystick.button8.whenPressed(new SolenoidRetract(RobotMap.Component.manipulator.hatchExtender)); //HatchExtenderIn());
		// FourBar			9-Toggle
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new RunIfElse(
			new SolenoidRetract("FourBarUp", RobotMap.Component.fourBar.lever),
			new SolenoidExtend("FourBarDown", RobotMap.Component.fourBar.lever),
			() -> RobotMap.Component.fourBar.lever.isExtended()));
		// 	() -> {boolean temp = RobotMap.Component.fourBar.lever.isExtended(); LogKitten.wtf(temp); return temp;}));
		RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new SolenoidExtend("FourBarUp", RobotMap.Component.fourBar.lever));
		RobotMap.HumanInput.Operator.joystick.button10.whenPressed(new SolenoidRetract("FourBarDown", RobotMap.Component.fourBar.lever));
		// Wrist			11-Up	12-Down
		RobotMap.HumanInput.Operator.joystick.button11.whenPressed(new SolenoidRetract(RobotMap.Component.manipulator.wrist)); //WristUp());
		RobotMap.HumanInput.Operator.joystick.button12.whenPressed(new SolenoidExtend(RobotMap.Component.manipulator.wrist));  //WristDown());

		

		
	
		// RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new OverrideEnable(RobotMap.Component.fourBar));
		// RobotMap.HumanInput.Operator.joystick.button9.whenReleased(new OverrideDisable(RobotMap.Component.fourBar));
	}
}