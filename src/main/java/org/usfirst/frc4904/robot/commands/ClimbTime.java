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
    public static final double FIRST_TIME = 2; //Change time as needed
    public static final double SECOND_TIME = 2; //Change time as needed
    public static final double THIRD_TIME = 2; //Change time as needed
    public static final double CHASSIS_SPEED = 2; //Change time as needed
	public ClimbTime() {
        super("ClimbTime"); //Decide whether to do robot alignment on lvl 2, or back away from lvl 2 accurately
        addParallel(new FrontLiftExtend());
        addSequential(new ChassisConstant(Component.chassis, 0, CHASSIS_SPEED, 0, FIRST_TIME));
        addSequential(new BackLiftExtend());
        addSequential(new FrontLiftRetract());
        addSequential(new ChassisConstant(Component.chassis, 0, CHASSIS_SPEED, 0, SECOND_TIME));
        addSequential(new BackLiftRetract());
        addSequential(new ChassisConstant(Component.chassis, 0, CHASSIS_SPEED, 0, THIRD_TIME));
	}
}