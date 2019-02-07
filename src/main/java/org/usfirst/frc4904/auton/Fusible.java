package org.usfirst.frc4904.auton;


import org.usfirst.frc4904.standard.custom.Nameable;

public interface Fusible<T> extends Nameable {
    T getValue();

    boolean trustable();
}
