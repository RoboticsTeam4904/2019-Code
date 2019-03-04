package org.usfirst.frc4904.robot.autonly;

import java.nio.ByteBuffer;
import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;
import java.util.Optional;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.custom.CustomCAN;

public class UpdateableData {
	public static double betaRF;
	public static double betaFloor;
	public static double theta;
	public static double x;
	public static double y;
	public static double distance;
	public static boolean isRFTapeVisible;
	public static boolean isFloorTapeVisible;

	public static Command update() throws UnsupportedOperationException {
		switch (AutonConfig.VISION_INTERFACE_TYPE) {
			case NETWORK_TABLES:
				return new NTUpdate();
			case CAN:
				return new CANUpdate();
			default:
				throw new UnsupportedOperationException();
		}
	}

	public static class NTUpdate extends Command {
		@Override
		protected void initialize() {
			betaRF = RobotMap.NetworkTables.Sensors.betaRF.getDouble(0);
			betaFloor = RobotMap.NetworkTables.Sensors.betaFloor.getDouble(0);
			theta = RobotMap.NetworkTables.Sensors.theta.getDouble(0);
			x = RobotMap.NetworkTables.Sensors.x.getDouble(0);
			y = RobotMap.NetworkTables.Sensors.y.getDouble(0);
			distance = RobotMap.NetworkTables.Sensors.distance.getDouble(0);
			isRFTapeVisible = RobotMap.NetworkTables.Sensors.isRFTapeVisible.getBoolean(false);
			isFloorTapeVisible = RobotMap.NetworkTables.Sensors.isFloorTapeVisible.getBoolean(false);
		}
		protected boolean isFinished() {
			return true;
		}
	}
	
	private static class VisionCAN {
		private final CustomCAN xChannel;
		private final CustomCAN yChannel;
		private final CustomCAN thetaChannel;
		private final CustomCAN betaChannel;
		private final CustomCAN distanceChannel;
		private final CustomCAN isTrustableChannel;

		private VisionCAN() {
			xChannel = new CustomCAN("Vision::x", 0x11000);
			yChannel = new CustomCAN("Vision::y", 0x11001);
			thetaChannel = new CustomCAN("Vision::theta", 0x11010);
			betaChannel = new CustomCAN("Vision::beta", 0x11011);
			distanceChannel = new CustomCAN("Vision::distance", 0x11100);
			isTrustableChannel = new CustomCAN("Vision::isTrustable", 0x11101);
		}

		protected ByteBuffer bytesToBuffer(byte[] bytes) {
			final ByteBuffer buffer = ByteBuffer.allocateDirect(bytes.length);
			buffer.put(bytes);
			return buffer;
		}

		protected Optional<Double> getX() {
			return xChannel.read()
				.map(bytes -> bytesToBuffer(bytes).getDouble());
		}

		protected Optional<Double> getY() {
			return yChannel.read()
				.map(bytes -> bytesToBuffer(bytes).getDouble());
		}
		
		protected Optional<Double> getTheta() {
			return thetaChannel.read()
				.map(bytes -> bytesToBuffer(bytes).getDouble());
		}
		
		protected Optional<Double> getBeta() {
			return betaChannel.read()
				.map(bytes -> bytesToBuffer(bytes).getDouble());
		}

		protected Optional<Double> getDistance() {
			return distanceChannel.read()
				.map(bytes -> bytesToBuffer(bytes).getDouble());
		}

		protected Optional<Boolean> getIsTrustable() {
			return isTrustableChannel.read()
				.map(bytes -> bytes[0] == 0x01);
		}
	}

	public static class CANUpdate extends Command {
		@Override
		protected void initialize() {
			final VisionCAN visionCAN = new VisionCAN();

			betaRF = visionCAN.getBeta().orElse(betaRF);
			theta = visionCAN.getTheta().orElse(theta);
			x = visionCAN.getX().orElse(x);
			y = visionCAN.getY().orElse(y);
			distance = visionCAN.getDistance().orElse(distance);
			isRFTapeVisible = visionCAN.getIsTrustable().orElse(isRFTapeVisible);
		}
		protected boolean isFinished() {
			return true;
		}
	}

	public static final DoubleSupplier getBetaRF = () -> betaRF;
	public static final DoubleSupplier getBetaFloor = () -> betaFloor;
	public static final DoubleSupplier getTheta = () -> theta;
	public static final DoubleSupplier getX = () -> x;
	public static final DoubleSupplier getY = () -> y;
	public static final DoubleSupplier getDistance = () -> distance;
	public static final BooleanSupplier getIsRFTapeVisible = () -> isRFTapeVisible;
	public static final BooleanSupplier getIsFloorTapeVisible = () -> isFloorTapeVisible;
}