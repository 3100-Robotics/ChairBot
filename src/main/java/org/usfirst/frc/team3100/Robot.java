package org.usfirst.frc.team3100;

    import edu.wpi.first.wpilibj.*;
    import edu.wpi.first.wpilibj.IterativeRobot;
    import edu.wpi.first.wpilibj.command.Command;
    import edu.wpi.first.wpilibj.command.Scheduler;
    import edu.wpi.first.wpilibj.networktables.NetworkTable;
    import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    import org.usfirst.frc.team3100.commands.Auto;
    import org.usfirst.frc.team3100.subsystems.MainDrive;
    import org.usfirst.frc.team3100.subsystems.Shooter;

public class Robot extends IterativeRobot{

    public static MainDrive drive;
    public static Shooter shooter;
    CameraServer server;
    public NetworkTable table;
    public static OI oi;
    private static ZMultiCamera camera = new ZMultiCamera("cam0", "cam5");
    private static NetworkTable networkTable;
    public static boolean autoVal;
    public float driveTest;
    Command autonomousCommand;


    public void robotInit() {
//        server = CameraServer.getInstance();
//        server.startAutomaticCapture();
        camera.start();
        table = NetworkTable.getTable("Test table");
        RobotMap.gyro.calibrate();
        Timer.delay(5);
        networkTable = NetworkTable.getTable("3t");
        driveTest = 0;
        shooter = new Shooter();
        drive = new MainDrive();
        SmartDashboard.putData("MainDrive", drive);
        oi = new OI();
    }


    public void autonomousInit() {
        autoVal = true;
        if(shooter != null) shooter.shoot();

    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        autoVal = false;
        table.putNumber("test", oi.getDriveMoveSpeed());

        Scheduler.getInstance().run();
    }

    public void testPeriodic() {

    }

    public static NetworkTable getNetworkTable() {
        return networkTable;
    }


}

