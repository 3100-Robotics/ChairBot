package org.usfirst.frc.team3100;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3100.XBoxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3100.commands.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import java.awt.*;

import static org.usfirst.frc.team3100.RobotMap.controller;
import static org.usfirst.frc.team3100.RobotMap.controls;

/**
 * Created by nicco on 2/15/17.
 */


    public class OI {
    private XBoxController controller = RobotMap.controls;
    private Button shootButton = new JoystickButton(controller, XBoxController.leftBumper);
    private Button camAddButton = new JoystickButton(controller, XBoxController.aButton);
    private Button camSubButton = new JoystickButton(controller, XBoxController.bButton);
    private Button camStartButton = new JoystickButton(controller, XBoxController.bButton);

    public boolean shootState = true;
    public boolean moveState = true;

    public double getDriveMoveSpeed() {
            return controls.getLeftStickY();
        }



    public double getRotateSpeed() {return controls.getRightStickX();
        }
        public double getModifier() {
            return controls.getRightTrigger();
        }
        public OI() {

            shootButton.whenPressed(new Shoot());

        }





    }
