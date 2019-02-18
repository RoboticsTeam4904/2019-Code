package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.FourBarElevator.State;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidSet;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Set FourBarElevator to a state
 */
public class FourBarElevatorSet extends CommandGroup {

	public FourBarElevatorSet(String name, State state) {
		super(name);
		requires(RobotMap.Component.fourBar.elevator);
		requires(RobotMap.Component.fourBar.lever);
		// TODO: Set the wrist up before doing this if going to LEVEL_ONE or above
		addParallel(new MotorPositionConstant(RobotMap.Component.fourBar.elevator, state.elevatorPosition));
		addSequential(new SolenoidSet(RobotMap.Component.fourBar.lever, state.fourBarState));
		addSequential(new NeutralElevator());
		RobotMap.Component.fourBar.setState(state);
	}
}
