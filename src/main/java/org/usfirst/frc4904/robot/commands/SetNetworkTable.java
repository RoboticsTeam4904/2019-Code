package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.KittenCommand;
import org.usfirst.frc4904.standard.LogKitten;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTable;

// TODO: Move to standard
public class SetNetworkTable extends Command {
	protected NetworkTableEntry nte;
	protected Object value;
	public SetNetworkTable(NetworkTableEntry nte, Object value) {
		this.nte = nte;
		this.value = value;
	}

	@Override
	protected void initialize() {
		this.nte.setValue(this.value);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}