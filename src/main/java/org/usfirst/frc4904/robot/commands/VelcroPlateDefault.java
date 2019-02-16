package org.usfirst.frc4904.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.HatchOuttakeExtend;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.VelcroPistonExtend;

public class VelcroPlateDefault extends CommandGroup {
	public VelcroPlateDefault() {
		super("VelcroPlateDefault");
		requires(RobotMap.Component.floorio.velcroPiston);
		requires(RobotMap.Component.floorio.hatchOuttakePiston);
		addParallel(new HatchOuttakeExtend()); // Both are in released state.
		addParallel(new VelcroPistonExtend());
	}
}