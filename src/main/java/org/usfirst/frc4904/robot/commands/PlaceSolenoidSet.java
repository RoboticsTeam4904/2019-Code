package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command sets the state of the associated group.
 */
public class PlaceSolenoidSet extends Command {
	protected final boolean clasped;

	public PlaceSolenoidSet(boolean clasped) {
		super("PlaceSolenoidSet");
		requires(RobotMap.Component.Floorio.velcroPlate.placeSolenoid);
		this.clasped = clasped;
	}

   	@Override
	protected void initialize() {
		RobotMap.Component.Floorio.velcroPlate.placeSolenoid.set(this.clasped);
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}