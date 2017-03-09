package org.usfirst.frc.team3100.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3100.RobotMap;


public class Shooter extends Subsystem {


    private static Spark ballFeeder = RobotMap.ballFeeder;
    private Spark shooterMotor = RobotMap.shootMotor;
    private Encoder rotSpeed = RobotMap.shootCheck;



    public void initDefaultCommand() {

    }


    public void shoot() {
        shooterMotor.set(-0.52);
        ballFeeder.set(1);
    }

    public void stopShooting() {
        shooterMotor.set(0);
        ballFeeder.set(0);
    }

}