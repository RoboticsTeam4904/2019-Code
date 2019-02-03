package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.commands.SolenoidRelease;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidSubsystem extends Subsystem {
    protected final DoubleSolenoid[] solenoids;
    protected final boolean isInverted;

    public enum SolenoidState {
        EXTENDED(DoubleSolenoid.Value.kForward), RELEASED(DoubleSolenoid.Value.kReverse);
        public final DoubleSolenoid.Value value;

        private SolenoidState(DoubleSolenoid.Value state) {
            this.value = state;
        }
    }

    public SolenoidSubsystem(String name, boolean isInverted, DoubleSolenoid... solenoids) {
        super(name);
        this.isInverted = isInverted;
        this.solenoids = solenoids;
    }

    public SolenoidSubsystem(String name, DoubleSolenoid... solenoids) {
        this(name, false, solenoids);
    }

    public SolenoidSubsystem(DoubleSolenoid... solenoids) {
        this("SolenoidSubsystem", solenoids);
    }

    public SolenoidState invertState(SolenoidState state) {
        if (state == SolenoidState.EXTENDED) {
            return SolenoidState.RELEASED;
        }
        else {
            return SolenoidState.EXTENDED;
        }
    }
    public void set(SolenoidState state) {
        if (isInverted) {
            state = invertState(state);
        }
        for (DoubleSolenoid solenoid : solenoids) {
            solenoid.set(state.value);
        }
    }

    public DoubleSolenoid[] getSolenoids() {
        return solenoids;
    }

    public boolean isExtended() {
        return solenoids[0].get() == SolenoidState.EXTENDED.value;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new SolenoidRelease(this));
    }
}