package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * @author ishanmadan
 */
public class ElevatorController implements RobotController {
    RobotProperties properties = new RobotProperties();

    DoubleSolenoid elevatorLeft = properties.getElevatorLeft();
    DoubleSolenoid elevatorRight = properties.getElevatorRight();

    boolean elevatorUp = properties.joystick.getButtonSeven();
    boolean elevatorDown = properties.joystick.getButtonEleven();
    
    public ElevatorController() {

    }

    @Override
    public String getName() {
        return "ElevatorController";
    }

    @Override
    public boolean performAction(RobotProperties properties) {
        elevatorUp = properties.joystick.getButtonSeven();
        elevatorDown = properties.joystick.getButtonEleven();
        
        if (elevatorUp) {
            elevatorLeft.set(DoubleSolenoid.Value.kForward);
            elevatorRight.set(DoubleSolenoid.Value.kForward);
        } else if (elevatorDown) {
            elevatorLeft.set(DoubleSolenoid.Value.kReverse);
            elevatorRight.set(DoubleSolenoid.Value.kReverse);
        } else {
            elevatorLeft.set(DoubleSolenoid.Value.kOff);
            elevatorRight.set(DoubleSolenoid.Value.kOff);
        }

        return true;
    }
}