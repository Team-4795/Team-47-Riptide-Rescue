package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arms;

public class LiftArm extends CommandBase {
   private final Arms m_arms;

   public LiftArm (Arms subsystem, double speed) {
       m_arms = subsystem;
       addRequirements(m_arms);
       double m_speed = speed;
    }

    @Override
    public void execute() {
        m_arms.moveArm();
    }
}