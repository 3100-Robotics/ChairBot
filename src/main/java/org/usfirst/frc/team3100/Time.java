package org.usfirst.frc.team3100;

/**
 * Created by Aiden on 3/7/17, Uses Zach's Code
 */
public class Time {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
