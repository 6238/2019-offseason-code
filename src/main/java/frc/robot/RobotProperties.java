package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author ishanmadan
 */

public class RobotProperties {
    JoystickController joystick;

    public ADXRS450_Gyro gyro;

    public WPI_TalonSRX frontLeft;
    public WPI_TalonSRX frontRight;
    public WPI_TalonSRX rearLeft;
    public WPI_TalonSRX rearRight;

    private MecanumDrive robotDrive;

    private PowerDistributionPanel pdp;

    public RobotProperties() {
        joystick = new JoystickController(0);

        gyro = new ADXRS450_Gyro();

        pdp = new PowerDistributionPanel();

        frontLeft = new WPI_TalonSRX(4);
        frontRight = new WPI_TalonSRX(3);
        rearLeft = new WPI_TalonSRX(2);
        rearRight = new WPI_TalonSRX(1);
        
        SmartDashboard.putBoolean("selfAlign", false);
        SmartDashboard.putBoolean("ReverseTurn", false);

        frontLeft.setInverted(true);
        frontRight.setInverted(true);
        rearLeft.setInverted(true);
        rearRight.setInverted(true);

        robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    }

    public MecanumDrive getRobotDrive() {
        return robotDrive;
    }
}