// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final CANSparkMax armMotor1 = new CANSparkMax(ARM_MOTOR1, ARM_MOTOR_TYPE);
  private final CANSparkMax armMotor2 = new CANSparkMax(ARM_MOTOR2, ARM_MOTOR_TYPE);
  private final MotorControllerGroup armDrive = new MotorControllerGroup(armMotor1, armMotor2);
  /** Creates a new Arm. */
  public Arm() {
    armMotor1.restoreFactoryDefaults();
    armMotor2.restoreFactoryDefaults();

    //set current limits
    // armMotor1.setSmartCurrentLimit(ARM_CURRENT);
    // armMotor2.setSmartCurrentLimit(ARM_CURRENT);

    //set idle behavior
    armMotor1.setIdleMode(ARM_IDLE_TYPE);
    armMotor2.setIdleMode(ARM_IDLE_TYPE);
  }

  public void climbUp() {
    armDrive.set(ARM_SPEED);
  }

  public void climbDown() {
    armDrive.set(-ARM_SPEED);
  }

  public void stop() {
    armDrive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
