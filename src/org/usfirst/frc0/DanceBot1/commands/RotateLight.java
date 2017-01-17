package org.usfirst.frc0.DanceBot1.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.DanceBot1.Robot;
import org.usfirst.frc0.DanceBot1.subsystems.LightRotater;

public class RotateLight extends Command 
{
    public RotateLight() 
    {
    	requires(Robot.lightRotater);
    }

    protected void initialize() 
    {
    	
    }

    protected void execute()
    {
    	Robot.lightRotater.move(0.25);
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    	Robot.lightRotater.move(0.0);
    }

    protected void interrupted() 
    {
    	end();
    }
}
