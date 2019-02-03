package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.PlaceSolenoidUp;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.PickupSolenoidUp;

public class VelcroPlateDefault extends CommandGroup {
	public VelcroPlateDefault() {
                super("VelcroPlateDefault");
                requires(RobotMap.Component.pickupSolenoid);
                requires(RobotMap.Component.placeSolenoid);
                addParallel(new PlaceSolenoidUp()); // Both are in released state.
                addParallel(new PickupSolenoidUp());
	}
}