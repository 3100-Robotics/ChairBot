package org.usfirst.frc.team3100;

    //import edu.wpi.cscore.UsbCamera;
    import edu.wpi.cscore.UsbCamera;
    import edu.wpi.first.wpilibj.*;
    import edu.wpi.first.wpilibj.IterativeRobot;
    import edu.wpi.first.wpilibj.command.Command;
    import edu.wpi.first.wpilibj.command.Scheduler;
    import edu.wpi.first.wpilibj.networktables.NetworkTable;
    import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    import edu.wpi.first.wpilibj.vision.VisionThread;
    import org.opencv.core.Rect;
    import org.opencv.imgproc.Imgproc;
    import org.usfirst.frc.team3100.commands.Auto;
    import org.usfirst.frc.team3100.subsystems.MainDrive;
    import org.usfirst.frc.team3100.subsystems.Shooter;
    import edu.wpi.first.wpilibj.CameraServer;
    import edu.wpi.first.wpilibj.IterativeRobot;
    import edu.wpi.first.wpilibj.RobotDrive;
    //import edu.wpi.cscore.VideoCamera;
    //import edu.wpi.cscore.VideoSource;
    //import org.opencv.core.Rect;
    //import org.opencv.imgproc.Imgproc;



public class Robot extends IterativeRobot{

    public static MainDrive drive;
    public static Shooter shooter;

    //public CameraServer server;
    public NetworkTable table;
    public static OI oi;
    private static NetworkTable networkTable;
    public static boolean autoVal;
    public float driveTest;

    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;

    private VisionThread visionThread;
    private double centerX = 0.0;

    private final Object imgLock = new Object();

    public void robotInit() {
        //server = CameraServer.getInstance();
        //server.startAutomaticCapture("cam0", 0);
        UsbCamera server = CameraServer.getInstance().startAutomaticCapture("cam0", 0);
        server.setBrightness(50);
        server.setResolution(IMG_WIDTH, IMG_HEIGHT);
        networkTable = NetworkTable.getTable("3t");
        driveTest = 0;
        shooter = new Shooter();
        drive = new MainDrive();
        SmartDashboard.putData("MainDrive", drive);
        oi = new OI();

    }


    public void autonomousInit() {
        autoVal = true;

    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

    }

    public void teleopPeriodic() {

        autoVal = false;

        Scheduler.getInstance().run();
    }

    public void testPeriodic() {

    }



}

