package org.usfirst.frc.team3100;

    import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
    import edu.wpi.first.wpilibj.command.Scheduler;
    import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    import org.usfirst.frc.team3100.subsystems.MainDrive;

public class Robot extends IterativeRobot {

    public static MainDrive drive;

    public void robotInit() {

        RobotMap.gyro.calibrate();
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
