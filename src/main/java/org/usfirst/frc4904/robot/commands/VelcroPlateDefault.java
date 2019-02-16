package org.usfirst.frc4904.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4904.robot.commands.PushPistonExtend;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.VelcroPistonExtend;

public class VelcroPlateDefault extends CommandGroup {
	public VelcroPlateDefault() {
		super("VelcroPlateDefault");
		requires(RobotMap.Component.floorio.velcroPiston);
		requires(RobotMap.Component.floorio.pushPiston);
		addParallel(new PushPistonExtend()); // Both are in released state.
		addParallel(new VelcroPistonExtend());
	}
}