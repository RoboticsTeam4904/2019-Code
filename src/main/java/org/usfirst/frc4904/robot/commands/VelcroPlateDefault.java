package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidRelease;
import org.usfirst.frc4904.robot.commands.PickupSolenoidRelease;

public class VelcroPlateDefault extends CommandGroup {
	public VelcroPlateDefault() {
        super("VelcroPlateDefault");
        addParallel(new PlaceSolenoidRelease()); // Both are in released state.
        addParallel(new PickupSolenoidRelease());
	}
}