package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;;

/**
 * @author ishanmadan
 */

public class VisionController implements RobotController {

    // camera1 is for sandstorm, camera2 is for alignment
    private UsbCamera camera1;
    private UsbCamera camera2;

    // dimensions of the video
    private final int width = 160;
    private final int height = 120;
    private final int fps = 120;
    
    public VisionController(RobotProperties properties) {
        try {
            camera1 = CameraServer.getInstance().startAutomaticCapture(0);
            camera1.setResolution(width, height);
            camera1.setFPS(fps);
        } catch (Exception e) {
            System.out.println("Camera 1 (location 0) not found");
        }

        /* try {
            camera2 = CameraServer.getInstance().startAutomaticCapture(1);
            camera2.setResolution(width, height);
            camera2.setFPS(fps);
        } catch (Exception e) {
            System.out.println("Camera 2 (location 1) not found");
        } */
    }

    @Override
    public String getName() {
        return "VisionController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {
        
        return true;
    }

}