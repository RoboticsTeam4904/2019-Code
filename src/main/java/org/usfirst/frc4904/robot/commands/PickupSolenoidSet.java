package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command sets the state of the associated group.
 */
public class PickupSolenoidSet extends Command {
	protected final boolean clasped;

	public PickupSolenoidSet(boolean clasped) {
		super("PickupSolenoidSet");
		requires(RobotMap.Component.Floorio.velcroPlate.pickupSolenoid);
		this.clasped = clasped;
	}

   	@Override
	protected void initialize() {
		RobotMap.Component.Floorio.velcroPlate.pickupSolenoid.set(this.clasped);
	}

	protected boolean isFinished() {
		return false;
	}
}