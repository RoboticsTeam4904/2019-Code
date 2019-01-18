package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Climber;
import org.usfirst.frc4904.robot.commands.BackLiftRetract;
import org.usfirst.frc4904.robot.commands.BackLiftExtend;
import org.usfirst.frc4904.robot.commands.FrontLiftRetract;
import org.usfirst.frc4904.robot.commands.FrontLiftExtend;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class Climb extends CommandGroup {
    public static final double WAIT_TIME = 2;
    public static final double DISTANCE = 2; //Change distance as neede
	public Climb() {
        super("Climb"); //Decide whether to do robot alignment on lvl 2, or back away from lvl 2 accurately
        addParallel(new FrontLiftExtend());
		addSequential(new ChassisMoveDistance(DISTANCE));
		addParallel(new FrontLiftRetract());
	}
}