package org.usfirst.frc4904.robot.autonly;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.DistanceFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class PathfinderBasic extends Command {
    double leftDistanceOffset = RobotMap.Component.leftWheelEncoder.getDistance();
    double rightDistanceOffset = RobotMap.Component.rightWheelEncoder.getDistance();
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
        0.05, 1.7, 2.0, 60.0);
    Trajectory trajectory;
    TankModifier modifier;
    DistanceFollower leftTrajectory;
    DistanceFollower rightTrajectory;

    public PathfinderBasic(Waypoint... waypoints) {
        requires(RobotMap.Component.leftWheelA);
        requires(RobotMap.Component.leftWheelB);
        requires(RobotMap.Component.rightWheelA);
        requires(RobotMap.Component.rightWheelB);
        trajectory = Pathfinder.generate(waypoints, config);
        modifier = new TankModifier(trajectory).modify(RobotMap.Metrics.ROBOT_WIDTH_METERS);
        leftTrajectory = new DistanceFollower(modifier.getLeftTrajectory());
        rightTrajectory = new DistanceFollower(modifier.getRightTrajectory());
        leftTrajectory.configurePIDVA(0.0, 0.0, 0.0, 0.0, 0.0); // TODO: set these PIDVA values
        rightTrajectory.configurePIDVA(0.0, 0.0, 0.0, 0.0, 0.0);
    }

    @Override
    protected void initialize() {
        leftDistanceOffset = RobotMap.Component.leftWheelEncoder.getDistance();
        rightDistanceOffset = RobotMap.Component.rightWheelEncoder.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double leftOutput = leftTrajectory.calculate(RobotMap.Component.leftWheelEncoder.getDistance() - leftDistanceOffset);
        double rightOutput = rightTrajectory
            .calculate(RobotMap.Component.rightWheelEncoder.getDistance() - rightDistanceOffset);
        RobotMap.Component.leftWheelA.set(leftOutput);
        RobotMap.Component.leftWheelB.set(leftOutput);
        RobotMap.Component.rightWheelA.set(rightOutput);
        RobotMap.Component.rightWheelB.set(rightOutput);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return leftTrajectory.isFinished() && rightTrajectory.isFinished();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}