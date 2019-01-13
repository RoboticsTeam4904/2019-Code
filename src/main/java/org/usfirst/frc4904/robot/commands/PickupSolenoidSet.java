package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command sets the state of the associated group.
 */
public class PickupSolenoidSet extends Command {
	protected final boolean clasped;

	public PickupSolenoidSet(boolean clasped) {
		requires(RobotMap.Component.velcroPlate);
		this.clasped = clasped;
	}

	// Called just before this Command runs for the first time
   	@Override
	protected void initialize() {
		System.out.println("The command has initialized!");
		RobotMap.Component.velcroPlate.setPickupSolenoid(this.clasped);
	}

	protected boolean isFinished() {
		return false;
	}
}