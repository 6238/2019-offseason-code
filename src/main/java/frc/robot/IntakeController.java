package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author ishanmadan
 */
public class IntakeController implements RobotController {
    RobotProperties properties;

    WPI_TalonSRX intakeLeft;
    WPI_TalonSRX intakeRight;

    boolean intakeIn;
    boolean intakeOut;

    double intakeSpeed = 1;
   
    public IntakeController(RobotProperties inputProperties) {
        SmartDashboard.putNumber("intakeSpeed", intakeSpeed);
        properties = inputProperties;

        intakeLeft = properties.getIntakeLeft();
        intakeRight = properties.getIntakeRight();

        intakeIn = properties.joystick.getButtonThree();
        intakeOut = properties.joystick.getButtonFive();
    }
   
    

    @Override
    public String getName() {
        return "IntakeController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {
        intakeIn = properties.joystick.getButtonThree();
        intakeOut = properties.joystick.getButtonFive();

        intakeSpeed = SmartDashboard.getNumber("intakeSpeed", intakeSpeed);
        
        if (intakeIn) {
            intakeLeft.set(intakeSpeed);
            intakeRight.set(intakeSpeed);
        } else if (intakeOut) {
            intakeLeft.set(-intakeSpeed);
            intakeRight.set(-intakeSpeed);
        } else {
            intakeLeft.set(0);
            intakeRight.set(0);
        }

        return true;
    }
}