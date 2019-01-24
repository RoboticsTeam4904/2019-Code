package org.usfirst.frc4904.robot.commands;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Command;

public class MonkeySee extends Command {
    static final String RECORD_FILE_PATH = "/home/lvuser/logs/monkey_see.csv";
    private File recordFile;
    private BufferedOutputStream outputStream;
    private Timer timer;
    private SeeTask task;
    static final Motor[] MOTOR_LIST = new Motor[] {RobotMap.Component.leftMotorA, RobotMap.Component.leftMotorB,
            RobotMap.Component.rightMotorA, RobotMap.Component.rightMotorB};

    public MonkeySee() {
        recordFile = new File(MonkeySee.RECORD_FILE_PATH);
        timer = new Timer();
        task = new SeeTask();
    }

    @Override
    protected void initialize() {
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(recordFile));
        }
        catch (FileNotFoundException e) {
            LogKitten.e(e);
        }
        timer.scheduleAtFixedRate(task, 20, 20);
    }

    @Override
    protected void end() {
        task.cancel();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    class SeeTask extends TimerTask {
        @Override
        public void run() {
            String outString = Arrays.stream(MOTOR_LIST).map(Motor::get).map(Object::toString)
                .collect(Collectors.joining(",", "", "\n"));
            try {
                outputStream.write(outString.getBytes());
            }
            catch (IOException e) {
                LogKitten.e(e);
            }
        }
    }
}