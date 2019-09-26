package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * @author ishanmadan
 */
public class ElevatorController implements RobotController {
    RobotProperties properties;

    DoubleSolenoid elevatorSolenoid;

    boolean elevatorUp;
    boolean elevatorDown;
    
    public ElevatorController(RobotProperties inputProperties) {
        properties = inputProperties;
        elevatorSolenoid = properties.getElevatorSolenoid();
        elevatorUp = properties.joystick.getButtonSix();
        elevatorDown = properties.joystick.getButtonFour();
    }

    @Override
    public String getName() {
        return "ElevatorController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {
        elevatorUp = properties.joystick.getButtonSix();
        elevatorDown = properties.joystick.getButtonFour();
        
        if (elevatorUp) {
            elevatorSolenoid.set(DoubleSolenoid.Value.kForward);
        } else if (elevatorDown) {
            elevatorSolenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            elevatorSolenoid.set(DoubleSolenoid.Value.kOff);
        }

        return true;
    }
}