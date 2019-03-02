package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.ManipulatirArm;
import org.usfirst.frc4904.robot.commands.ManipulatirClaws;
import org.usfirst.frc4904.robot.commands.ManipulatirGround;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Manipulator {
	public static final double INTAKE_SPEED = -1;
	public static final double OUTTAKE_SPEED = -1;
	public final Arm arm;
	public final Claws claws;
	public final Motor rollers;
	public final Ground ground;

	public Manipulator(Arm arm, Claws claws, Motor rollers, Ground ground) {
		this.arm = arm;
		this.claws = claws;
		this.rollers = rollers;
		this.ground = ground;
	}
	
	public static class Arm extends Subsystem {
		public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value DOWN = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid arm;

		public Arm(DoubleSolenoid arm) {
			super("Manipulator Arm");
			this.arm = arm;
		}

		public boolean isUp() {
			return this.arm.get() == UP;
		}

		public void set(boolean up) {
			if (up) {
				this.arm.set(UP);
			} else {
				this.arm.set(DOWN);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new ManipulatirArm());
		}
	}

	public static class Claws extends Subsystem {
		public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value DOWN = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid claws;

		public Claws(DoubleSolenoid claws) {
			super("Manipulator Claws");
			this.claws = claws;
		}

		public boolean isClosed() {
			return this.claws.get() == UP;
		}

		public void set(boolean up) {
			if (up) {
				this.claws.set(UP);
			} else {
				this.claws.set(DOWN);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new ManipulatirClaws());
		}
	}

	public static class Ground extends Subsystem {
		public static final DoubleSolenoid.Value UP = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value DOWN = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid ground;

		public Ground(DoubleSolenoid ground) {
			super("Manipulator Ground");
			this.ground = ground;
		}

		public boolean isClosed() {
			return this.ground.get() == UP;
		}

		public void set(boolean up) {
			if (up) {
				this.ground.set(UP);
			} else {
				this.ground.set(DOWN);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new ManipulatirGround());
		}
	}
}