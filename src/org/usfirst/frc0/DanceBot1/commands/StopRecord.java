package org.usfirst.frc0.DanceBot1.commands;

import java.io.IOException;

import org.usfirst.frc0.DanceBot1.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopRecord extends Command
{
	public StopRecord()
	{
		requires(Robot.teleopRecorder);
	}
	
    protected void initialize() 
    {
    	Robot.isRecording = false;
    }

    protected void execute() 
    {
    	
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() 
    {
    	
    }

    protected void interrupted() 
    {
    	end();
    }
}
