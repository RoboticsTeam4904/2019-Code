package org.usfirst.frc4904.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc4904.standard.LogKitten;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Streams with multiple cameras
 */
public class CameraStream extends Command {
    private final int streamingXRes = 640;
    private final int streamingYRes = 480;
    private final int streamingFPS = 30;
    private final VideoMode.PixelFormat streamingFmt = VideoMode.PixelFormat.kMJPEG;
    private final VideoSink server;
    private final ArrayList<UsbCamera> cameras;

    public CameraStream(int numCameras) {
        cameras = new ArrayList<>(numCameras);
        for (int i = 0; i < numCameras; ++i) {
            cameras.add(CameraServer.getInstance().startAutomaticCapture(i));
            cameras.get(i).setVideoMode(streamingFmt, streamingXRes, streamingYRes, streamingFPS);
            cameras.get(i).setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        }
        server = CameraServer.getInstance().getServer();
    }

    @Override
    protected void initialize() {
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