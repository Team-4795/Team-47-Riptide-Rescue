// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arms;

public class MoveArmBack extends CommandBase {
private final Arms m_arms;

public MoveArmBack (Arms subsystem) {
  m_arms = subsystem;
  addRequirements(m_arms);
 }

  @Override
  public void execute() {
    m_arms.moveArmBack();
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
