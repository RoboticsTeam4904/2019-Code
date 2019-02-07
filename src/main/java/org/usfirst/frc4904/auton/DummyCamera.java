package org.usfirst.frc4904.auton;


import org.usfirst.frc4904.auton.AligningCamera;;

public class DummyCamera extends AligningCamera {
    private double angle;

    public DummyCamera(double angle) {
        this.angle = angle;
    }

    @Override
    public double getDegrees() {
        return this.angle;
    }

    @Override
    public double getDistance() {
        return Double.NaN;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public boolean trustable() {
        return true;
    }
};