package org.usfirst.frc0.DanceBot1.commands;

import java.io.FileNotFoundException;

import org.usfirst.frc0.DanceBot1.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PlayTeleop extends Command
{
	public PlayTeleop()
	{
		requires(Robot.teleopRecorder);
	}
	
    protected void initialize() 
    {
    	try
    	{
			Robot.teleopRecorder.setupPlayback();
		} 
    	catch (FileNotFoundException e)
    	{
			e.printStackTrace();
		}
    }

    protected void execute() 
    {
    	Robot.teleopRecorder.play();
    }

    protected boolean isFinished() 
    {
        return !Robot.teleopRecorder.isPlaying();
    }

    protected void end() 
    {
    	Robot.teleopRecorder.endPlayback();
    }

    protected void interrupted() 
    {
    	end();
    }
}
