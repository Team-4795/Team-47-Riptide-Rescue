package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Intake extends SubsystemBase {

    PWMVictorSPX LeftIntake = new PWMVictorSPX(8);
    PWMVictorSPX RightIntake = new PWMVictorSPX(9);

    // these are not the correct ports; placeholders
    public Intake(){
    }

    public void moveIntakeForward() {
        LeftIntake.set(.5);
        RightIntake.set(.5);
    }   

    public void moveIntakeBack() {
        LeftIntake.set(-0.5);
        RightIntake.set(.5);
    }
}

