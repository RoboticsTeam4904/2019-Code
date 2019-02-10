package org.usfirst.frc4904.robot.commands;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Streams with multiple cameras
 */
public class CameraStream extends Command {
    private final VideoMode.PixelFormat format;
    private final int xRes;
    private final int yRes;
    private final int fps;
    private final UsbCamera cameras[];

    public CameraStream(int xRes, int yRes, int fps, VideoMode.PixelFormat format, UsbCamera... cameras) {
        this.xRes = xRes;
        this.yRes = yRes;
        this.fps = fps;
        this.format = format;
        this.cameras = cameras;
    }

    @Override
    protected void initialize() {
        for (int i = 0; i < cameras.length; ++i) {
            cameras[i] = CameraServer.getInstance().startAutomaticCapture(i);
            cameras[i].setVideoMode(format, xRes, yRes, fps);
            cameras[i].setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        }
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}