package org.usfirst.frc4904.robot.autonly;

import org.usfirst.frc4904.robot.RobotMap;

public class AutonConfig {
	public enum VisionInterfaceType {
		NETWORK_TABLES,
		CAN
	}

	public static final double DRIVE_TOLERANCE = RobotMap.Metrics.Robot.ROBOT_WIDTH / 2;
	public static final double MINIMUM_VISION_DISTANCE = 18.0;
	public static final double NO_CLOSER = Math.max(DRIVE_TOLERANCE, MINIMUM_VISION_DISTANCE);
	public static final VisionInterfaceType VISION_INTERFACE_TYPE = VisionInterfaceType.NETWORK_TABLES;
}