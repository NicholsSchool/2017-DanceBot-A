package org.usfirst.frc0.DanceBot1.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.DanceBot1.Robot;


public class TankDrive extends Command 
{
    public TankDrive() 
    {
    	requires(Robot.driveTrain);
    }

    protected void initialize() 
    {
    	
    }

    protected void execute() 
    {
    	Robot.driveTrain.move(0.1, 0.1);
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    	Robot.driveTrain.disable();
    }

    protected void interrupted() 
    {
    	end();
    }
}
