package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author ishanmadan
 */
public class IntakeController implements RobotController {
    RobotProperties properties = new RobotProperties();

    WPI_TalonSRX intakeLeft = properties.getIntakeLeft();
    WPI_TalonSRX intakeRight = properties.getIntakeRight();

    boolean intakeIn = properties.joystick.getButtonThree();
    boolean intakeOut = properties.joystick.getButtonFive();

    boolean solenoidIn = properties.joystick.getButtonFour();
    boolean solenoidOut = properties.joystick.getButtonSix();

    DoubleSolenoid intakeSolenoid = properties.getIntakeSolenoid();

    double intakeSpeed = 0.5;

    public IntakeController() {
        SmartDashboard.putNumber("intakeSpeed", intakeSpeed);
    }

    @Override
    public String getName() {
        return "IntakeController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {
        intakeIn = properties.joystick.getButtonThree();
        intakeOut = properties.joystick.getButtonFive();

        solenoidIn = properties.joystick.getButtonFour();
        solenoidOut = properties.joystick.getButtonSix();

        intakeSpeed = SmartDashboard.getNumber("intakeSpeed", intakeSpeed);
        
        if (intakeIn) {
            intakeLeft.set(intakeSpeed);
            intakeRight.set(intakeSpeed);
        } else if (intakeOut) {
            intakeLeft.set(-intakeSpeed);
            intakeRight.set(-intakeSpeed);
        }

        if (solenoidIn) {
            intakeSolenoid.set(DoubleSolenoid.Value.kForward);
        } else if (solenoidOut) {
            intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            intakeSolenoid.set(DoubleSolenoid.Value.kOff);
        }

        return true;
    }
}