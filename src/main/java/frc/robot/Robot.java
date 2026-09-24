// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot { 

  private final PWMSparkMax A_leftMotor = new PWMSparkMax(0);
  private final PWMSparkMax T_leftMotor = new PWMSparkMax(1);
  private final PWMSparkMax A_rightMotor = new PWMSparkMax(2);
  private final PWMSparkMax T_rightMotor = new PWMSparkMax(3);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(A_leftMotor::set, A_rightMotor::set);
  private final XboxController m_controller= new XboxController(0);
  public Robot() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

    A_leftMotor.addFollower(T_leftMotor);
    A_rightMotor.addFollower(T_rightMotor);
      A_rightMotor.setInverted(true);

   } 

  @Override
  public void teleopPeriodic() {
    m_robotDrive.tankDrive(-m_controller.getLeftY(), -m_controller.getRightY());
  }
}



