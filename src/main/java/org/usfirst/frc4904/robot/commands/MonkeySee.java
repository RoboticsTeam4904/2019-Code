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
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Command;

public class MonkeySee extends Command {
    static final String RECORD_FILE_PATH = "/home/lvuser/logs/monkey_see.csv";
    static final String VOLTAGE_FILE_PATH = "/home/lvuser/logs/monkey_see_voltage.csv";
    private File recordFile;
    private File recordVoltageFile;
    private BufferedOutputStream outputStream;
    private BufferedOutputStream voltageOutputStream;
    private Timer timer;
    private SeeTask task;
    static final Motor[] MOTOR_LIST = new Motor[] {RobotMap.Component.leftMotorA, RobotMap.Component.leftMotorB,
            RobotMap.Component.rightMotorA, RobotMap.Component.rightMotorB};

    public MonkeySee() {
        recordFile = new File(MonkeySee.RECORD_FILE_PATH);
        recordVoltageFile = new File(MonkeySee.VOLTAGE_FILE_PATH);
        timer = new Timer();
        task = new SeeTask();
    }

    @Override
    protected void initialize() {
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(recordFile));
            voltageOutputStream = new BufferedOutputStream(new FileOutputStream(recordVoltageFile));
        }
        catch (FileNotFoundException e) {
            LogKitten.e(e);
        }
        timer.scheduleAtFixedRate(task, 20, 20);
    }

    @Override
    protected void end() {
        try {
            outputStream.flush();
            voltageOutputStream.flush();
        }
        catch (IOException e) {
            LogKitten.e(e);
        }
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
                String voltageString = RobotMap.Component.pdp.getVoltageSafely() + "\n";
                try {
                    outputStream.write(outString.getBytes());
                    voltageOutputStream.write(voltageString.getBytes());
                }
                catch (IOException e) {
                    LogKitten.e(e);
                }
            }
            catch (InvalidSensorException e) {
                LogKitten.e(e);
            }
        }
    }
}