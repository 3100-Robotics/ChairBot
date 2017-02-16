package org.usfirst.frc.team3100.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3100.RobotMap;
import org.usfirst.frc.team3100.commands.Drive;
import java.lang.Math;

/**
 * Created by nicco on 2/14/17.
 */
public class MainDrive extends PIDSubsystem {

    private SpeedController leftMotor = RobotMap.leftMotor;
    private SpeedController rightMotor = RobotMap.rightMotor;
    private RobotDrive mainDrive = new RobotDrive(leftMotor, rightMotor);
    private Gyro gyro = RobotMap.gyro;
    private double targetMove = 0;
    private double targetRotate = 0;
    private boolean DEBUG = true;

    static double setting = 0.0; //Need to remember the value instead of 0

    public static double setHeading(double Rj, double Sj, double Gy){

        double Rs = 0.10;
        double Jz = 0.17;


        if((Math.abs(Rj) < Jz) && (Math.abs(Sj) < Jz)){
            //void gyro.calibrate();
            setting = Gy % 360.0;
        } else {
            setting = (setting + (Rj * Rs)) % 360.0;
        }
        return setting;

    }


    public MainDrive(){

        super("MainDrive", 0.5,0,0);
        setOutputRange(-1,1);
        setInputRange(0, 360);
        getPIDController().setContinuous();
        SmartDashboard.putNumber("P", getPIDController().getP());
        SmartDashboard.putNumber("I", getPIDController().getI());
        SmartDashboard.putNumber("D", getPIDController().getD());
        SmartDashboard.putNumber("SetPoint", getSetpoint());
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    protected double returnPIDInput() {
        SmartDashboard.putNumber("Gryo", gyro.getAngle());
        return gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("PID Output", output);
        mainDrive.arcadeDrive(targetMove, -output);
    }
    public void drive(double move, double rotate) {
        targetMove = 0;
        setSetpoint(setHeading(rotate, move, gyro.getAngle()));

        enable();

        if (DEBUG) {
            getPIDController().setPID(
                SmartDashboard.getNumber("P"),
                SmartDashboard.getNumber("I"),
                SmartDashboard.getNumber("D")
            );
        }
        SmartDashboard.putNumber("P", getPIDController().getP());
        SmartDashboard.putNumber("I", getPIDController().getI());
        SmartDashboard.putNumber("D", getPIDController().getD());
        SmartDashboard.putNumber("SetPoint", getSetpoint());
    }

}