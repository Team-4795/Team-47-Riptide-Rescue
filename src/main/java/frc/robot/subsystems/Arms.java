package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.Constants;

public class Arms extends SubsystemBase {

    PWMVictorSPX LeftArm = new PWMVictorSPX(Constants.ARMZ);
    // these are not the correct ports; placeholders
    public Arms(){
    }

    public void setArmSpeed(double speed) {
        LeftArm.set(speed);
    }   
    public void stopArms(){
        LeftArm.set(0);
    }
}

