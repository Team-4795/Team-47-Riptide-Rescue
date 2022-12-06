package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arms;

public class LiftArm extends CommandBase {
   private final Arms m_arms;
   double m_speed;

   public LiftArm (Arms subsystem, double speed) {
       m_arms = subsystem;
       addRequirements(m_arms);
       m_speed = speed;
    }

    @Override
    public void execute() {
        m_arms.moveArm(m_speed);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}