// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  // TO-DO Create two PWMTalonSRX motor controllers
  PWMTalonSRX left = new PWMTalonSRX(Constants.LEFT_MOTOR);
  PWMTalonSRX right = new PWMTalonSRX(Constants.RIGHT_MOTOR);

  // TO-DO Set up the differential drive controller
  DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    diffDrive.setMaxOutput(.67);
    left.setInverted(true);
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    //TO-DO Call the arcade drive method
    diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
