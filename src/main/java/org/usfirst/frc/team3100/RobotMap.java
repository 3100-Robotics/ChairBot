package org.usfirst.frc.team3100;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * Created by nicco on 2/14/17.
 */
public class RobotMap {

    public static int controller = 1;
    private static int leftDriveChannel = 0;
    private static int rightDriveChannel = 1;
    private static int shootChannel = 3;
    public static int ballFeederChanel = 6;
    private static int tankCycleMotor = 4;
    private static int servoX = 8;
    private static int servoY = 9;

    public static Jaguar shootMotor = new Jaguar(shootChannel);
    public static Jaguar ballFeeder = new Jaguar(ballFeederChanel);
    public static Jaguar tankCycle = new Jaguar(tankCycleMotor);

    public static Encoder shootCheck = new Encoder(0,1);

    public static XBoxController controls = new XBoxController(controller);
    public static SpeedController leftMotor = new Jaguar(leftDriveChannel);
    public static SpeedController rightMotor = new Jaguar(rightDriveChannel);
    public static Gyro gyro = new ADXRS450_Gyro();

    public static Servo xServo = new Servo(servoX);
    public static Servo yServo = new Servo(servoY);



}
