package org.usfirst.frc.team3100.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3100.Robot;
import org.usfirst.frc.team3100.RobotMap;
import org.usfirst.frc.team3100.XBoxController;
import org.usfirst.frc.team3100.subsystems.MainDrive;
import static org.usfirst.frc.team3100.Robot.shooter;

/**
 * Created by Aiden on 3/23/17.
 */
public class Auto extends Command {

    public Auto() {
        super("Auto");
        requires(Robot.drive);
        requires(shooter);

    }

    private static MainDrive drive = Robot.drive;
    private static XBoxController controller = RobotMap.controls;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        drive.drive(controller.getLeftStickY(), controller.getRightStickX());


    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){
        drive.drive(0, 0);
        shooter.
    }

    @Override
    protected void end() {

    }
}
}
