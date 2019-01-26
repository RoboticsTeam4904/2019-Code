package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.RobotMap.Component;
import org.usfirst.frc4904.robot.subsystems.Climber;
import org.usfirst.frc4904.robot.commands.BackLiftRetract;
import org.usfirst.frc4904.robot.commands.BackLiftExtend;
import org.usfirst.frc4904.robot.commands.FrontLiftRetract;
import org.usfirst.frc4904.robot.commands.FrontLiftExtend;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class ClimbDistance extends CommandGroup {
    public static final double BACK_WHEEL_DISTANCE = -1; //Change distance as needed
    public static final double FRONT_WHEEL_DISTANCE = -1; //Change distance as needed
    public static final double BOTH_WHEEL_DISTANCE = -1; //Change distance as needed
	public ClimbDistance() {
        super("ClimbDistance"); //Decide whether to do robot alignment on lvl 2, or back away from lvl 2 accurately
        addParallel(new FrontLiftExtend());
        addSequential(new ChassisMoveDistance(Component.chassis, BACK_WHEEL_DISTANCE, Component.drivePID));
        addParallel(new BackLiftExtend());
        addParallel(new FrontLiftRetract());
        addSequential(new ChassisMoveDistance(Component.chassis, FRONT_WHEEL_DISTANCE, Component.drivePID));
        addParallel(new BackLiftRetract());
        addSequential(new ChassisMoveDistance(Component.chassis, BOTH_WHEEL_DISTANCE, Component.drivePID));
	}
}