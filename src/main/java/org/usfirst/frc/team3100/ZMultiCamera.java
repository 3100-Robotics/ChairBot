package org.usfirst.frc.team3100;

/**
 * Created by Aiden on 3/7/17, Uses Zach's Code
 */
import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.CameraServer;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.vision.USBCamera;

import org.usfirst.frc.team3100.Time.*;

public class ZMultiCamera implements Runnable{

    private int camera1;
    private int camera2;
    private int currentCamera;

    private int fps = 20;
    private boolean running = true;

    private CameraServer cameraServer;
    private Image lastFrame;

    private Thread cameraThread = new Thread(this);

    public ZMultiCamera(String cameraName1, String cameraName2) {
        camera1 = NIVision.IMAQdxOpenCamera(cameraName1, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //camera2 = NIVision.IMAQdxOpenCamera(cameraName2, NIVision.IMAQdxCameraControlMode.CameraControlModeController);

        lastFrame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        currentCamera = camera1;
        startCapture(currentCamera);
    }


    public int getCamera1() {
        return camera1;
    }

    public int getCamera2() {
        return camera2;
    }

    public void setBrightness(int camreaID, int brightness){
        NIVision.IMAQdxSetAttributeString(camreaID, "CameraAttributes::Brightness::Mode", "Manual");
        long var14 = NIVision.IMAQdxGetAttributeMinimumI64(camreaID, "CameraAttributes::Brightness::Value");
        long var15 = NIVision.IMAQdxGetAttributeMaximumI64(camreaID, "CameraAttributes::Brightness::Value");
        long var16 = var14 + (long) ((double) (var15 - var14) * ((double) brightness / 100.0D));
        NIVision.IMAQdxSetAttributeI64(camreaID, "CameraAttributes::Brightness::Value", var16);
    }


    public void start(){
        cameraServer = CameraServer.getInstance();
        running = true;
        cameraThread.start();
    }

    public void stop(){
        running = false;
    }

    public void pushImage(){
        NIVision.IMAQdxGrab(currentCamera, lastFrame, 1);
        cameraServer.setImage(lastFrame);
    }

    public void startCapture(int id){
        NIVision.IMAQdxStopAcquisition(currentCamera);
        NIVision.IMAQdxConfigureGrab(id);
        NIVision.IMAQdxStartAcquisition(id);
    }

    @Override
    public void run() {
        while (running){
            pushImage();
            Time.sleep(1000 / fps);

        }
    }
}
