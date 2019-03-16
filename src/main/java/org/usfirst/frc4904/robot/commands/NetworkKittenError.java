package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Network kitten error stuff
 */
public class NetworkKittenError extends CommandGroup {
	public NetworkKittenError(String message) {
		addParallel(new KittenCommand(message, LogKitten.KittenLevel.WTF));
		addParallel(new SetNetworkTable(RobotMap.NetworkTables.SafetyChecks.conflict, true));
		addSequential(new WaitCommand(1));
		addSequential(new SetNetworkTable(RobotMap.NetworkTables.SafetyChecks.conflict, false));
	}
}