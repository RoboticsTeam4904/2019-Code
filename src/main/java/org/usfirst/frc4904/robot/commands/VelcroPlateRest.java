package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidUp;
import org.usfirst.frc4904.robot.commands.PickupSolenoidUp;

public class VelcroPlateRest extends CommandGroup {
	public VelcroPlateRest() {
        super("VelcroPlateRest");
        addParallel(new PlaceSolenoidUp()); // Both are in released state.
        addParallel(new PickupSolenoidUp());
	}
}