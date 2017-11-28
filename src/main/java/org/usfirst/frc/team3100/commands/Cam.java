package org.usfirst.frc.team3100.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3100.Robot;


public class Cam extends Command {
    public Cam() {
        super("Camera");
        requires(Robot.camera);

    }

    public void initialize() {
        Robot.camera.movePos();
    }

    public void execute() {

    }

    public boolean isFinished() {
        return true;
    }

    public void end() {

    }

    public void interrupted() {

    }
}

