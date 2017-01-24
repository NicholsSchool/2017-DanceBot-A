package org.usfirst.frc0.DanceBot1.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.DanceBot1.Robot;
import org.usfirst.frc0.DanceBot1.RobotMap;


public class TankDrive extends Command 
{
    public TankDrive() 
    {
    	requires(Robot.driveTrain);
    }

    protected void initialize() 
    {
    	Robot.driveTrain.move(0.0, 0.0);
    }

    protected void execute() 
    {
    	Robot.driveTrain.move(Robot.oi.getJoystick0Y(), Robot.oi.getJoystick0Y());
   /* if (Robot.oi.getJoystick0Y() > 0.1)
    {
    	Robot.driveTrain.move(0.3, 0.3);
    }*/
    
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    	Robot.driveTrain.move(0.0, 0.0);
    }

    protected void interrupted() 
    {
    	end();
    }
}
