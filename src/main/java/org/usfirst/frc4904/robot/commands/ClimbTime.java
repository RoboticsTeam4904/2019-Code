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
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.commands.chassis.ChassisConstant;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class ClimbTime extends CommandGroup {
    public static final double BACK_WHEEL_TIME = -1; //Change time as needed
    public static final double FRONT_WHEEL_TIME = -1; //Change time as needed
    public static final double BOTH_WHEEL_TIME = -1; //Change time as needed
    public static final double CHASSIS_SPEED = -1; //Change speed as needed
	public ClimbTime() {
        super("ClimbTime"); //Decide whether to do robot alignment on lvl 2, or back away from lvl 2 accurately
        addParallel(new FrontLiftExtend());
        addSequential(new ChassisConstant(Component.chassis, 0, CHASSIS_SPEED, 0, BACK_WHEEL_TIME));
        addParallel(new BackLiftExtend());
        addParallel(new FrontLiftRetract());
        addSequential(new ChassisConstant(Component.chassis, 0, CHASSIS_SPEED, 0, FRONT_WHEEL_TIME));
        addParallel(new BackLiftRetract());
        addSequential(new ChassisConstant(Component.chassis, 0, CHASSIS_SPEED, 0, BOTH_WHEEL_TIME));
	}
}