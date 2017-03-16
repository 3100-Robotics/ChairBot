package org.usfirst.frc.team3100.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3100.RobotMap;


public class Shooter extends Subsystem {


    private static Jaguar ballFeeder = RobotMap.ballFeeder;
    private static Jaguar shooterMotor = RobotMap.shootMotor;
    private static Jaguar tankCycle = RobotMap.tankCycle;
    private Encoder rotSpeed = RobotMap.shootCheck;



    public void initDefaultCommand() {

    }


    public void shoot() {
        shooterMotor.set(-0.80);
        Timer.delay(3.5);
        ballFeeder.set(-1);
        tankCycle.set(1);
    }

    public void stopShooting() {
        shooterMotor.set(0);
        ballFeeder.set(0);
        tankCycle.set(0);
    }

}