package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command sets the state of the associated group.
 */
public class PlaceSolenoidSet extends Command {
	protected final boolean clasped;

	public PlaceSolenoidSet(boolean clasped) {
		requires(RobotMap.Component.velcroPlate);
		this.clasped = clasped;
	}

	// Called just before this Command executes for the first time
   	@Override
	protected void initialize() {
		System.out.println("The command has initialized!");
		RobotMap.Component.velcroPlate.setPlaceSolenoid(this.clasped);
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}