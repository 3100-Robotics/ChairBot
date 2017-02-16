package org.usfirst.frc.team3100;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * Created by nicco on 2/14/17.
 */
public class RobotMap {

    public static int controller = 1;
    private static int leftDriveChannel = 2;
    private static int rightDriveChannel = 3;


    public static XBoxController controls = new XBoxController(controller);
    public static SpeedController leftMotor = new Jaguar(leftDriveChannel);
    public static SpeedController rightMotor = new Jaguar(rightDriveChannel);
    public static Gyro gyro = new ADXRS450_Gyro();




}
