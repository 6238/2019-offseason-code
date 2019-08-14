package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by imadan on 8/14/19.
 */
public class DriveTrainController implements RobotController {
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

    // self align
    boolean selfAlign = false;

    // straight driving
    boolean straightDrive = false;

    private double kAngleSetpoint = 0.0;
    private double kP = 0.1;

    public DriveTrainController() {
        // send values to dashboard
        SmartDashboard.putNumber("insanityFactor", insanityFactor);
        SmartDashboard.putBoolean("reverseDrive", reverseDrive);
        SmartDashboard.putBoolean("joyDrive", joyDrive);
        SmartDashboard.putBoolean("brakeMode", brakeMode);
        SmartDashboard.putBoolean("absoluteDrive", absoluteDrive);
        SmartDashboard.putBoolean("selfAlign", selfAlign);
    }

    // name function for initial testing
    @Override
    public String getName() {
        return "DriveTrainController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {

        MecanumDrive robotDrive = properties.getRobotDrive();

        selfAlign = SmartDashboard.getBoolean("selfAlign", false);

        insanityFactor = SmartDashboard.getNumber("insanityFactor", insanityFactor);

        reverseDrive = SmartDashboard.getBoolean("reverseDrive", reverseDrive);

        joyDrive = SmartDashboard.getBoolean("joyDrive", joyDrive);

        brakeMode = SmartDashboard.getBoolean("brakeMode", brakeMode);

        absoluteDrive = SmartDashboard.getBoolean("absoluteDrive", absoluteDrive);

        if (selfAlign) {
            if (properties.joystick.getJoystickZ() == 0) {
                straightDrive = true;

                double turningValue = (kAngleSetpoint - properties.gyro.getAngle()) * kP;

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
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), turningValue, kAngleSetpoint);
                } else {
                    // normal driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), turningValue);
                }

            } else {
                kAngleSetpoint = properties.gyro.getAngle();
                straightDrive = false;
                if (reverseDrive) {
                    // reverse driving
                    robotDrive.driveCartesian(-insanityFactor * properties.joystick.getJoystickX(), insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
                } else if (absoluteDrive) {
                    // absolute driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ(), kAngleSetpoint);
                } else {
                    // normal driving
                    robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
                }
            }

        } else if (joyDrive) {
            kAngleSetpoint = properties.gyro.getAngle();
            straightDrive = false;
            if (reverseDrive) {
                // reverse driving
                robotDrive.driveCartesian(-insanityFactor * properties.joystick.getJoystickX(), insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
            } else if (absoluteDrive) {
                // absolute driving
                robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ(), kAngleSetpoint);
            } else {
                // normal driving
                robotDrive.driveCartesian(insanityFactor * properties.joystick.getJoystickX(), -insanityFactor * properties.joystick.getJoystickY(), insanityFactor * properties.joystick.getJoystickZ());
            }
            /*  */

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