package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.RobotMap.Component.NetworkTables;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int xboxController = 1;

        }
        public static class CANMotor {}
        public static class PWM {}
        public static class CAN {}
        public static class Pneumatics {}
    }
    
    public static class Metrics{}
    public static class Component {
        public static class NetworkTables{
            public static NetworkTableInstance inst;

            public static class Vision {
                public static NetworkTable table;
                public static NetworkTableEntry x;
                public static NetworkTableEntry y;
                public static NetworkTableEntry beta;
                public static NetworkTableEntry dist;
                public static NetworkTableEntry frameNum;
                //x=1, y=1, theta=10, beta=5, dist=2, frameNum=1
            }
        }
        public static CustomXbox driverXbox;
    }
    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }
        public static class Operator {}
    }
    public RobotMap() {
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.Vision.table = NetworkTables.inst.getTable("Vision");
        NetworkTables.Vision.x = NetworkTables.Vision.table.getEntry("x");
        NetworkTables.Vision.y = NetworkTables.Vision.table.getEntry("y");
        NetworkTables.Vision.beta = NetworkTables.Vision.table.getEntry("beta");
        NetworkTables.Vision.dist = NetworkTables.Vision.table.getEntry("dist");
        NetworkTables.Vision.frameNum = NetworkTables.Vision.table.getEntry("frameNum");

        Component.driverXbox = new CustomXbox(Port.HumanInput.xboxController);
		Component.driverXbox.setDeadZone(0.1);
    }
}
