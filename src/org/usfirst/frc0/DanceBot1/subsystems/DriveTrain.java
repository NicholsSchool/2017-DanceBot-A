package org.usfirst.frc0.DanceBot1.subsystems;

import java.awt.Robot;

import org.usfirst.frc0.DanceBot1.RobotMap;
import org.usfirst.frc0.DanceBot1.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem 
{
    private final CANTalon leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final RobotDrive robotDrive4 = RobotMap.driveTrainRobotDrive4;

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new TankDrive());
    }
    
    public void move(double rightAmount, double leftAmount)
    {
    	//robotDrive4.tankDrive(leftAmount, rightAmount);
    	
    	// use for testing
    	leftFrontMotor.set(leftAmount);
    	//leftRearMotor.set(leftAmount);
    	//rightFrontMotor.set(rightAmount);
    	//rightFrontMotor.set(rightAmount);
    }
    
    public void disable()
    {
    	leftFrontMotor.disable();
    }
}

