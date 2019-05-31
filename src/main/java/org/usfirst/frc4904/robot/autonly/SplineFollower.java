package org.usfirst.frc4904.robot.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4904.motioncontrol.pathing.PathGenerator;
import org.usfirst.frc4904.motioncontrol.pathing.SplineGenerator;
import org.usfirst.frc4904.motioncontrol.MotionTrajectory;
import org.usfirst.frc4904.motioncontrol.MotionTrajectoryPoint;
import org.usfirst.frc4904.motioncontrol.Tuple;

public class SplineFollower extends Command { // In part borrowed from Jaci's Pathfinder
  public static final double robotMaxVel = 5;
  public static final double robotMaxAccel = 1;
  public static final double plantWidth = 0.25; // radius
  double kP, kI, kD, kV, kA;
  int i = 0;
  Tuple<MotionTrajectoryPoint, MotionTrajectoryPoint> lastPoint;
  MotionTrajectory motionTrajectory;
  double tickTime = 20;
  double leftDistanceOffset = RobotMap.Component.leftWheelEncoder.getDistance();
  double rightDistanceOffset = RobotMap.Component.rightWheelEncoder.getDistance();

  public SplineFollower(PathGenerator spline, double kP, double kI, double kD, double kV, double kA) {
    requires(RobotMap.Component.leftWheelA);
    requires(RobotMap.Component.leftWheelB);
    requires(RobotMap.Component.rightWheelA);
    requires(RobotMap.Component.rightWheelB);
    this.motionTrajectory = new MotionTrajectory(spline, plantWidth, tickTime);
    this.configurePIDVA(kP, kI, kD, kV, kA);
  }

  @Override
  protected void initialize() {
    MotionTrajectoryPoint motionTrajectoryPoint = new MotionTrajectoryPoint(0, 0, 0, 0);
    lastPoint = new Tuple<>(motionTrajectoryPoint, motionTrajectoryPoint);
    leftDistanceOffset = RobotMap.Component.leftWheelEncoder.getDistance();
    rightDistanceOffset = RobotMap.Component.rightWheelEncoder.getDistance();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Tuple<MotionTrajectoryPoint, MotionTrajectoryPoint> newPoint = motionTrajectory.calcPoint(i, lastPoint);
    MotionTrajectoryPoint left = newPoint.getX();
    MotionTrajectoryPoint right = newPoint.getY();
    double leftOutput = calculateSpeed(RobotMap.Component.leftWheelEncoder.getDistance() - leftDistanceOffset, left);
    double rightOutput = calculateSpeed(RobotMap.Component.rightWheelEncoder.getDistance() - rightDistanceOffset, right);
    RobotMap.Component.leftWheelA.set(leftOutput);
    RobotMap.Component.leftWheelB.set(leftOutput);
    RobotMap.Component.rightWheelA.set(rightOutput);
    RobotMap.Component.rightWheelB.set(rightOutput);
    lastPoint = newPoint;
    i++;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return i >= motionTrajectory.getTickTotal();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  /**
   * Configure the PID/VA Variables for the Follower
   * 
   * @param kP
   *           The proportional term. This is usually quite high (0.8 - 1.0 are common values)
   * @param kI
   *           The integral term. Currently unused.
   * @param kD
   *           The derivative term. Adjust this if you are unhappy with the tracking of the follower. 0.0 is the default
   * @param kV
   *           The velocity ratio. This should be 1 over your maximum velocity @ 100% throttle.
   *           This converts m/s given by the algorithm to a scale of -1..1 to be used by your
   *           motor controllers
   * @param kA
   *           The acceleration term. Adjust this if you want to reach higher or lower speeds faster. 0.0 is the default
   */
  public void configurePIDVA(double kP, double kI, double kD, double kV, double kA) {
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    this.kV = kV;
    this.kA = kA;
  }

  public double calculateSpeed(double distance_covered, MotionTrajectoryPoint seg) {
    if (i < motionTrajectory.getTickTotal()) {
      double error = seg.pos - distance_covered; // TODO: error based on position or velocity?
      double calculated_value = kP * error + // Proportional
      // kD * ((error - last_error) / tickTime) + // Derivative
        (kV * seg.vel + kA * seg.accel); // V and A Terms
      // last_error = error;
      return calculated_value;
    } else return 0;
  }
}
