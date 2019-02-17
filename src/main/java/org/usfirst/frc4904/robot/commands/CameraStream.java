package org.usfirst.frc4904.robot.commands;


import java.util.ArrayList;
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
    private static final int STREAMING_X_RES = 320;
    private static final int STREAMING_Y_RES = 240;
    private static final int STREAMING_FPS = 15;
    private static final VideoMode.PixelFormat streamingFmt = VideoMode.PixelFormat.kMJPEG;
    private final VideoSink server;
    private final ArrayList<UsbCamera> cameras;

    public CameraStream(int numCameras, int streamingXRes, int streamingYRes, int streamingFPS) {
        cameras = new ArrayList<>(numCameras);
        for (int i = 0; i < numCameras; ++i) {
            cameras.add(CameraServer.getInstance().startAutomaticCapture(i));
            cameras.get(i).setVideoMode(streamingFmt, streamingXRes, streamingYRes, streamingFPS);
            cameras.get(i).setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        }
        server = CameraServer.getInstance().getServer();
    }

    public CameraStream(int numCameras) {
        this(numCameras, STREAMING_X_RES, STREAMING_Y_RES, STREAMING_FPS);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}