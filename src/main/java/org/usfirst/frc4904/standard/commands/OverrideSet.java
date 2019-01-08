package org.usfirst.frc4904.standard.commands;


import org.usfirst.frc4904.standard.custom.Overridable;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class OverrideSet extends InstantCommand {
	protected final boolean isOverridden;
	protected final Overridable[] overridables;

	public OverrideSet(boolean isOverridden, Overridable... overridables) {
		this.isOverridden = isOverridden;
		this.overridables = overridables;
	}

	@Override
	protected void initialize() {
		for (Overridable overridable : overridables) {
			overridable.setOverridden(isOverridden);
		}
	}
}
