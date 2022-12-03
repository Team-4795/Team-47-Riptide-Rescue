package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arms;

public class LiftArm extends CommandBase {
   private final Arms m_arms;

   public LiftArm (Arms subsystem, DoubleSupplier backwards, DoubleSupplier forwards) {
       m_arms = subsystem;
       addRequirements(m_arms);
    }

    @Override
    public void execute() {
        m_arms.moveArm();
    }
}