package org.usfirst.frc0.DanceBot1.subsystems;

import org.usfirst.frc0.DanceBot1.RobotMap;
import org.usfirst.frc0.DanceBot1.commands.*;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem 
{
    private final SpeedController leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final SpeedController leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final SpeedController rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final SpeedController rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final RobotDrive robotDrive4 = RobotMap.driveTrainRobotDrive4;

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new TankDrive());
    }
}

