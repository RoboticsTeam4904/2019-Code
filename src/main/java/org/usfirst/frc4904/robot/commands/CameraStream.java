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
    private static final int STREAMING_X_RES = 24;
    private static final int STREAMING_Y_RES = 24;
    private static final int STREAMING_FPS = 5;
    private static final VideoMode.PixelFormat streamingFmt = VideoMode.PixelFormat.kMJPEG;
    private final VideoSink server;
    private final ArrayList<UsbCamera> cameras;

    public CameraStream(int streamingXRes, int streamingYRes, int streamingFPS, int ...ports) {
        cameras = new ArrayList<>(ports.length);
        for (int i : ports) {
            cameras.add(CameraServer.getInstance().startAutomaticCapture(i));
			// cameras.get(i).setVideoMode(streamingFmt);
			cameras.get(i).setFPS(streamingFPS);
            cameras.get(i).setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        }
        server = CameraServer.getInstance().getServer();
    }

    public CameraStream(int ...ports) {
        this(STREAMING_X_RES, STREAMING_Y_RES, STREAMING_FPS, ports);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}