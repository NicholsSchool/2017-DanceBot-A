package org.usfirst.frc0.DanceBot1.subsystems;

import org.usfirst.frc0.DanceBot1.RobotMap;
import org.usfirst.frc0.DanceBot1.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


public class LightRotater extends Subsystem 
{
    private final CANTalon lightMotor = RobotMap.lightRotaterMotor;
    
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new RotateLight());
    }
    
    public void move(double amount)
    {
    	lightMotor.set(amount);
    }
}

