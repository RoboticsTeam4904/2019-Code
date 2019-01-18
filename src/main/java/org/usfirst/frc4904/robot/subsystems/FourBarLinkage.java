package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4904.robot.commands.FourBarLeverUp;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class FourBarLinkage extends Subsystem {
	public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value DOWN = DoubleSolenoid.Value.kReverse;
	protected final DoubleSolenoid lever;

	public FourBarLinkage(DoubleSolenoid lever) {
		super("Four Bar Linkage Lever Flipper");
		this.lever = lever;
	}

	public void set(boolean up) {
		if (up) this.lever.set(UP);
		else this.lever.set(DOWN);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new FourBarLeverUp());
	}
}