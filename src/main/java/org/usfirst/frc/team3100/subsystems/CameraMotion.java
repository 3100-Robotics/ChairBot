package org.usfirst.frc.team3100.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3100.GripPipeline;
import org.usfirst.frc.team3100.OI;
import org.usfirst.frc.team3100.RobotMap;

import static org.usfirst.frc.team3100.Robot.oi;


public class CameraMotion extends Subsystem {


    private static Servo servoX = RobotMap.xServo;
    private static Servo servoY = RobotMap.yServo;
    CameraServer server;



    public void initDefaultCommand() {

    }


    public void movePos() {

    }


}