package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author ishanmadan
 */
public class DriveTrainController implements RobotController {
    RobotProperties properties;
    MecanumDrive robotDrive;
    // speed multiplier/reducer
    double insanityFactor = 0.5;

    // inverted drive for hatch panel
    boolean reverseDrive = false;

    // joystick drive or no?
    boolean joyDrive = true;

    // brake mode
    boolean brakeMode = true;

    // absolute drive
    boolean absoluteDrive = false;

    // straight driving
    boolean straightDrive = false;

    // self align
    boolean selfAlign = false;

    private double headingAngle = 0.0; // the direction the straight driving code aims to stay on
    private double spinFactor = 0.01; // product of heading error & spinFactor is the Z-value given to straight driving code

    public DriveTrainController(RobotProperties inputProperties) {
        // send values to dashboard
        SmartDashboard.putNumber("insanityFactor", insanityFactor);
        SmartDashboard.putBoolean("reverseDrive", reverseDrive);
        SmartDashboard.putBoolean("joyDrive", joyDrive);
        SmartDashboard.putBoolean("brakeMode", brakeMode);
        SmartDashboard.putBoolean("absoluteDrive", absoluteDrive);
        SmartDashboard.putBoolean("straightDrive", straightDrive);
        SmartDashboard.putBoolean("selfAlign", selfAlign);

        SmartDashboard.putNumber("headingAngle", headingAngle);
        SmartDashboard.putNumber("spinFactor", spinFactor);
        
        properties = inputProperties;
        robotDrive = properties.getRobotDrive();
    }

    // name function for initial testing
    @Override
    public String getName() {
        return "DriveTrainController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {

        // get robotDrive, refresh values on dashboard
        insanityFactor = SmartDashboard.getNumber("insanityFactor", 0.5);
        reverseDrive = SmartDashboard.getBoolean("reverseDrive", false);
        joyDrive = SmartDashboard.getBoolean("joyDrive", true);
        brakeMode = SmartDashboard.getBoolean("brakeMode", true);
        absoluteDrive = SmartDashboard.getBoolean("absoluteDrive", false);
        straightDrive = SmartDashboard.getBoolean("straightDrive", false);
        SmartDashboard.putBoolean("selfAlign", selfAlign);

        spinFactor = SmartDashboard.getNumber("spinFactor", 0.01);

        /**
         * insanityFactor is a driver-controlled variable that lets the driver change the robot's
         * maximum speed. By default, insanityFactor is set at 0.5, since the robot at full speed
         * is much too fast. insanityFactor should only be set from the driver dashboard, and should
         * not be changed in the program.
         * 
         * 
         * reverseDrive was intended for the 2019 season, when there was a plan to use the back of
         * the robot to attach hatch panels. It's fairly straightforward, it just switches the
         * forward/backward controls and the right/left controls, so the driver can drive as if the
         * back of the robot is forward, and the front of the robot is backward.
         * 
         * 
         * joyDrive gives control of the robot to the joystick, and should ALWAYS be enabled. It was
         * originally somewhat of a joke, as disabling it would allow the driver to control the robot
         * not from the joystick, but from the mecanumDrive info panel on the driver dashboard.
         * WARNING: DO NOT DISABLE joyDrive FOR ANY REASON.
         * 
         * 
         * brakeMode allows the driver to toggle between brake mode and coast mode, for when the
         * joystick values are set back to zero (the driver let go of the joystick). brakeMode is
         * enabled by default, as the drivers prefer the robot to stop immediately.
         * 
         * 
         * absoluteDrive allows the driver to drive relative to the field, rather than the robot
         * itself. Forward would be defined as straight down the field, away from the driver.
         * absoluteDrive is disabled by default, and may not work.
         * 
         * 
         * straightDrive is a driver-enabled feature that keeps the robot going in one direction when:
         * a. straightDrive is enabled
         * b. the driver is not twisting the joystick (joyZ == 0)
         * 
         * When the driver enables straightDrive, the robot may not begin aligning itself immediately,
         * it only starts aligning when joyZ = 0. When the driver has enabled straightDrive, they
         * receive a visual indication on their driver dashboard. The driver knows that the robot is
         * aligning itself when the selfAlign toggle is also on. selfAlign will be on as long as the
         * robot is aligning itself. When the robot stops selfAligning, either because the driver
         * disabled straightDrive or because the driver twisted the joystick, selfAlign will
         * immediately switch off.
         * 
         * WARNING: As of 8/19/19, straightDrive does not work, and should not be used.
         */

        if (straightDrive) { // enable alignment mode, only tries to align when driver is not changing joyZ
            if (properties.joystick.getJoystickZ() == 0) {
                selfAlign = true; // tell driver selfAlign is working

                double turningValue = (headingAngle - properties.gyro.getAngle()) * spinFactor;
                    // turningValue is z-value given to robotDrive, must be less than 0.5 or robot spins out of control

                if (turningValue > 0.5) {
                    turningValue = 0.5;
                } else if (turningValue < -0.5) {
                    turningValue = -0.5;
                }

                if (reverseDrive) {
                    // reverseDrive switch
                    robotDrive.driveCartesian(-insanityFactor * properties.joystick.getJoystickX(), insanityFactor * properties.joystick.getJoystickY(), turningValue);
                } else if (absoluteDrive) {
                    // absolute driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), turningValue, headingAngle);
                } else {
                    // normal driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), turningValue);
                }
            } else {
                headingAngle = properties.gyro.getAngle(); // set heading to current direction, as soon as driver releases joyZ, the saved direction will be used
                selfAlign = false; // tell driver selfAlign is not working
                if (reverseDrive) {
                    // reverse driving
                    robotDrive.driveCartesian(-insanityFactor * properties.joystick.getJoystickX(), insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
                } else if (absoluteDrive) {
                    // absolute driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ(), headingAngle);
                } else {
                    // normal driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
                }
            }

        } else if (joyDrive) {
            headingAngle = properties.gyro.getAngle(); // set straightDrive heading to current direction, if driver switches to straightDrive, saved heading will be used
            selfAlign = false; // tell driver selfAlign is not on (obviously)
            if (reverseDrive) {
                // reverse driving
                robotDrive.driveCartesian(-insanityFactor * properties.joystick.getJoystickX(), insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
            } else if (absoluteDrive) {
                // absolute driving (drive relative to the field, not to the robot)
                robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ(), headingAngle);
            } else {
                // normal driving
                robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
                // System.out.println("after joyDrive");
            }

        }
        if (brakeMode) {
            properties.frontLeft.setNeutralMode(NeutralMode.Brake);
            properties.frontRight.setNeutralMode(NeutralMode.Brake);
            properties.rearLeft.setNeutralMode(NeutralMode.Brake);
            properties.rearRight.setNeutralMode(NeutralMode.Brake);
        } else {
            properties.frontLeft.setNeutralMode(NeutralMode.Coast);
            properties.frontRight.setNeutralMode(NeutralMode.Coast);
            properties.rearLeft.setNeutralMode(NeutralMode.Coast);
            properties.rearRight.setNeutralMode(NeutralMode.Coast);
        }
        return true;
    }
}