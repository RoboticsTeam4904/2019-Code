package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.ManipulatirArm;
import org.usfirst.frc4904.robot.commands.ManipulatirClaws;
import org.usfirst.frc4904.robot.commands.ManipulatirGround;
import org.usfirst.frc4904.robot.commands.ManipulatirGrabber;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Manipulator {
	public static final double INTAKE_SPEED = -1;
	public static final double OUTTAKE_SPEED = -1;
	public final Arm arm; // manipulator arm
	public final Claws claws; // cargo skid
	public final Motor rollers; // the wheels
	public final Ground ground; // the ground intake thing? idk
	public final Grabber grabber; // the hatch grabber thing? idk

	public Manipulator(Arm arm, Claws claws, Motor rollers, Ground ground, Grabber grabber) {
		this.arm = arm;
		this.claws = claws;
		this.rollers = rollers;
		this.ground = ground;
		this.grabber = grabber;
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

		public boolean isUp() {
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

		public boolean isUp() {
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

	public static class Grabber extends Subsystem {
		public static final DoubleSolenoid.Value IN = DoubleSolenoid.Value.kForward;
		public static final DoubleSolenoid.Value OUT = DoubleSolenoid.Value.kReverse;
		protected final DoubleSolenoid grabber;

		public Grabber(DoubleSolenoid grabber) {
			super("Manipulator Grabber");
			this.grabber = grabber;
		}

		public boolean isIn() {
			return this.grabber.get() == IN;
		}

		public void set(boolean in) {
			if (in) {
				this.grabber.set(IN);
			} else {
				this.grabber.set(OUT);
			}
		}

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new ManipulatirGrabber());
		}
	}
}