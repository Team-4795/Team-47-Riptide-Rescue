package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    PWMVictorSPX LeftIntake = new PWMVictorSPX(Constants.INTAKE);

    // these are not the correct ports; placeholders
    public Intake(){
    }

    public void moveIntakeForward(double speed) {
        LeftIntake.set(speed);
    }   

    public void moveIntakeBack(double speed) {
        LeftIntake.set(speed);
    }
    public void stopIntake() {
        LeftIntake.set(0);
    }
}

