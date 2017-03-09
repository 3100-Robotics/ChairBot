package org.usfirst.frc.team3100.subsystems;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3100.RobotMap;
import org.usfirst.frc.team3100.commands.Shoot;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import static edu.wpi.first.wpilibj.Relay.Value.kForward;
import static edu.wpi.first.wpilibj.Relay.Value.kOff;
import static edu.wpi.first.wpilibj.Relay.Value.kOn;


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