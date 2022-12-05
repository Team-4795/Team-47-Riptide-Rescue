package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.Encoder;

public class Arms  extends SubsystemBase {

    PWMVictorSPX LeftArm = new PWMVictorSPX(7);
    // these are not the correct ports; placeholders
    public Arms(){
    }

    public void moveArm() {
        LeftArm.set(.5);
    }   

    public void moveArmBack() {
        LeftArm.set(-0.5);
    }
}

