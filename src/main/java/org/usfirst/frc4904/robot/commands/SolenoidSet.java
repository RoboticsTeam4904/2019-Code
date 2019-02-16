package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidSet extends Command {
	protected final SolenoidState state;
	protected final SolenoidSubsystem system;

	public SolenoidSet(String name, SolenoidSubsystem system, SolenoidState state) {
		super(name, system);
		this.state = state;
		this.system = system;
	}

	public SolenoidSet(SolenoidSubsystem system, SolenoidState state) {
		this("SolenoidSet", system, state);
	}

	public void initialize() {
		for (DoubleSolenoid solenoid : system.getSolenoids()) {
			solenoid.set(state.value);
		}
	}

	public boolean isFinished() {
		return false;
	}
}