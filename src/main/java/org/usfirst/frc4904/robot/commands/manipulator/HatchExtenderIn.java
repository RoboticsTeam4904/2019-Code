package org.usfirst.frc4904.robot.commands.manipulator;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchExtenderIn extends RunIfElse {
	public HatchExtenderIn() {
		super(
			new HatchExtenderInAndHatchGrabberIn(),
			new KittenCommand("Cannot retract hatch extender piston due to hatch in grabber.", LogKitten.KittenLevel.WTF),
			() -> RobotMap.Component.manipulator.hatchGrabber.getState() != SolenoidState.EXTEND
		);
	}

	public static class HatchExtenderInAndHatchGrabberIn extends CommandGroup {
		public HatchExtenderInAndHatchGrabberIn() {
			addParallel(new SolenoidRetract("HatchGrabberIn", RobotMap.Component.manipulator.hatchGrabber));
			addParallel(new SolenoidRetract("HatchExtenderIn", RobotMap.Component.manipulator.hatchExtender));
		}
	}
}