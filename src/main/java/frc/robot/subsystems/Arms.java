package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;


public class Arms {

    Spark LeftArm = new Spark(0);
    Spark RightArm = new Spark(1);
    Encoder LeftArmEncoder = new Encoder(7, 5);
    Encoder RightArmEncoder = new Encoder(5, 7);
    //these are not the correct ports; placeholders

    public static boolean extended;

    public boolean getExtended(){
        return extended;
    }

    public void moveArms(double speed){
        LeftArm.SetSpeed(speed);
        RightArm.SetSpeed(speed);
    }
    
}
