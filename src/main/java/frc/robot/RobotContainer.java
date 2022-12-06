// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveTime;
import frc.robot.commands.LiftArm;
import frc.robot.commands.Outake;
import frc.robot.commands.MoveArmBack;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arms;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  // TO-DO Declare a joystick
  public Joystick driverController = new Joystick(Constants.DRIVER_Controller);
  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  Arms arms = new Arms();
  Intake m_intake = new Intake();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    configureButtonBindings();
  
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    m_drivetrain.setDefaultCommand(getArcadeDriveCommand());
    SmartDashboard.putData(m_chooser);
   
    final JoystickButton outtakeButton = new JoystickButton(driverController, 0);
    final JoystickButton armButton = new JoystickButton(driverController, 5);
    final JoystickButton intakeButton = new JoystickButton(driverController, 1);
    final JoystickButton armBackButton = new JoystickButton(driverController, 4);

    intakeButton.whileHeld(new RunCommand(() -> m_intake.moveIntakeForward()));
    outtakeButton.whileHeld(new RunCommand(() -> m_intake.moveIntakeBack()));
    armButton.whileHeld(new RunCommand(() -> arms.moveArm()));
    armBackButton.whileHeld(new RunCommand(() -> arms.moveArmBack()));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new DriveTime(Constants.DRIVE_SPEED, 2, m_drivetrain), 
      new LiftArm(arms, Constants.ARM_SPEED).withTimeout(1),
      new Outake(m_intake).withTimeout(3),
      new MoveArmBack(arms, Constants.ARM_SPEED).withTimeout(1));

  }
  public Command getArcadeDriveCommand()
  {   return new ArcadeDrive(
      m_drivetrain, () -> -driverController.getRawAxis(1), () -> driverController.getRawAxis(4));
  }
  /**
   * Use this to pass the teleop command to the main {@link Robot} class.
   *
   * @return the command to run in teleop
   */
}

