package org.usfirst.frc.team3100.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3100.Robot;
import org.usfirst.frc.team3100.RobotMap;
import org.usfirst.frc.team3100.XBoxController;
import org.usfirst.frc.team3100.subsystems.MainDrive;

import java.sql.Time;

public class Drive extends Command {


    public Drive(){
        super("Drive");
        requires(Robot.drive);
    }
    private static MainDrive drive = Robot.drive;
    private static XBoxController controller = RobotMap.controls;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if(Robot.autoVal == false) {
            drive.drive(controller.getLeftStickY(), controller.getRightStickX());
        } else {
            drive.drive(1,0);
            Timer.delay(2);
            drive.drive(0,0);

        }

    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){
        drive.drive(0, 0);
    }

    @Override
    protected void end() {

    }
}
