package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author ishanmadan
 */

public class RobotProperties {
    JoystickController joystick;

    public static int instanceCount = 0;

    public ADXRS450_Gyro gyro;

    public WPI_TalonSRX frontLeft;
    public WPI_TalonSRX frontRight;
    public WPI_TalonSRX rearLeft;
    public WPI_TalonSRX rearRight;

    public Compressor compressor;

    public DoubleSolenoid elevatorSolenoid;

    public DoubleSolenoid intakeSolenoid;

    public WPI_TalonSRX intakeLeft;
    public WPI_TalonSRX intakeRight;

    private MecanumDrive robotDrive;

    private PowerDistributionPanel pdp;

    public RobotProperties() {
        if (instanceCount > 0) {
            throw new RuntimeException("Only one RobotProperties instance is allowed per robot!");
        }
        
        instanceCount++;

        joystick = new JoystickController(0);

        gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

        pdp = new PowerDistributionPanel();

        frontLeft = new WPI_TalonSRX(4);
        frontRight = new WPI_TalonSRX(3);
        rearLeft = new WPI_TalonSRX(2);
        rearRight = new WPI_TalonSRX(1);

        elevatorSolenoid = new DoubleSolenoid(2, 3);

        compressor = new Compressor();

        intakeLeft = new WPI_TalonSRX(7);
        intakeRight = new WPI_TalonSRX(8);

        intakeSolenoid = new DoubleSolenoid(1, 0);

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

    public DoubleSolenoid getElevatorSolenoid() {
        return elevatorSolenoid;
    }

    public MecanumDrive getRobotDrive() {
        return robotDrive;
    }

    public DoubleSolenoid getIntakeSolenoid() {
        return intakeSolenoid;
    }

    public void pushData(RobotProperties properties) {
        // sends input, data values to SmartDashboard
        SmartDashboard.putNumber("Joystick X", properties.joystick.getJoystickX());
        SmartDashboard.putNumber("Joystick Y", properties.joystick.getJoystickY());
        SmartDashboard.putNumber("Joystick Z", properties.joystick.getJoystickZ());

        SmartDashboard.putNumber("Shutoff", properties.joystick.getSlider());

        SmartDashboard.putData("RobotDrive", properties.getRobotDrive());

        SmartDashboard.putData("Gyro", gyro);
        
        SmartDashboard.putData("pdp", pdp);

        SmartDashboard.putBoolean("Compressor", compressor.enabled());
        SmartDashboard.putBoolean("Pressure Switch", compressor.getPressureSwitchValue());
    }
}