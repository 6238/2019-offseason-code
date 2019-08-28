package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
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

    public Compressor compressor;

    public Solenoid elevatorLeft;
    public Solenoid elevatorRight;

    public Solenoid intakeSolenoid;

    public WPI_TalonSRX intakeLeft;
    public WPI_TalonSRX intakeRight;

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

        elevatorLeft = new Solenoid(5);
        elevatorRight = new Solenoid(6);

        compressor = new Compressor(7);

        intakeLeft = new WPI_TalonSRX(8);
        intakeRight = new WPI_TalonSRX(9);
        
        SmartDashboard.putBoolean("selfAlign", false);
        SmartDashboard.putBoolean("ReverseTurn", false);

        frontLeft.setInverted(true);
        frontRight.setInverted(true);
        rearLeft.setInverted(true);
        rearRight.setInverted(true);

        intakeLeft.setInverted(true);
        intakeRight.setInverted(false);

        robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    }

    public WPI_TalonSRX getIntakeLeft() {
        return intakeLeft;
    }

    public WPI_TalonSRX getIntakeRight() {
        return intakeRight;
    }

    public Compressor getCompressor() {
        return compressor;
    }

    public Solenoid elevatorLeft() {
        return elevatorLeft;
    }

    public Solenoid elevatorRight() {
        return elevatorRight;
    }

    public MecanumDrive getRobotDrive() {
        return robotDrive;
    }

    public void pushData(RobotProperties properties) {
        // sends input, data values to SmartDashboard
        SmartDashboard.putNumber("Joystick X", properties.joystick.getJoystickX());
        SmartDashboard.putNumber("Joystick Y", properties.joystick.getJoystickY());
        SmartDashboard.putNumber("Joystick Z", properties.joystick.getJoystickZ());

        SmartDashboard.putNumber("Shutoff", properties.joystick.getSlider());

        SmartDashboard.putData(properties.getRobotDrive());

        SmartDashboard.putData("Gyro", gyro);
        
        SmartDashboard.putData("pdp", pdp);
    }
}