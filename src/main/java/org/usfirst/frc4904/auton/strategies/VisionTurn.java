package org.usfirst.frc4904.auton.strategies;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.auton.AligningCamera;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class VisionTurn extends ChassisTurn {
    AligningCamera camera;

    public VisionTurn(AligningCamera camera) {
        super(RobotMap.Component.chassis, 0.0, RobotMap.Component.navx, RobotMap.Component.chassisTurnMC);
        this.camera = camera;
    }

    @Override
    protected void initialize() {
        super.initialize();
        initialAngle -= camera.getDegrees();
        RobotMap.Component.navx.setModeAlignment();
    }

    @Override
    protected void end() {
        super.end();
        RobotMap.Component.navx.setModeStandard();
    }
}
