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
    Waypoint[] points = new Waypoint[] { // TODO: these are just random waypoints.
            new Waypoint(-4, -1, Pathfinder.d2r(-45)),
            new Waypoint(-2, -2, 0),
            new Waypoint(0, 0, 0)
    };
    Trajectory trajectory = Pathfinder.generate(points, config);
    // Wheelbase Width = 0.5m
    TankModifier modifier = new TankModifier(trajectory).modify(0.5); // TODO: Modify
    // Do something with the new Trajectories...
    Trajectory left = modifier.getLeftTrajectory();
    Trajectory right = modifier.getRightTrajectory();
    DistanceFollower leftTrajectory = new DistanceFollower(left);
    DistanceFollower rightTrajectory = new DistanceFollower(right);

    public PathfinderBasic() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.Component.leftWheelA);
        requires(RobotMap.Component.leftWheelB);
        requires(RobotMap.Component.rightWheelA);
        requires(RobotMap.Component.rightWheelB);
        leftTrajectory.configurePIDVA(0.0, 0.0, 0.0, 0.0, 0.0);
        rightTrajectory.configurePIDVA(0.0, 0.0, 0.0, 0.0, 0.0);
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