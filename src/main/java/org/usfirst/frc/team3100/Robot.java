package org.usfirst.frc.team3100;

    import edu.wpi.first.wpilibj.*;
    import edu.wpi.first.wpilibj.IterativeRobot;
    import edu.wpi.first.wpilibj.command.Scheduler;
    import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    import org.usfirst.frc.team3100.subsystems.MainDrive;

public class Robot extends IterativeRobot {

    public static MainDrive drive;

    public void robotInit() {

        RobotMap.gyro.calibrate();
        Timer.delay(5);
        drive = new MainDrive();
        SmartDashboard.putData("MainDrive", drive);
    }

    public void autonomousInit() {

    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {

        Scheduler.getInstance().run();
    }

    public void testPeriodic() {

    }
}
