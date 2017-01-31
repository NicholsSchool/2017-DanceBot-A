package org.usfirst.frc0.DanceBot1.commands;

import java.io.FileNotFoundException;

import org.usfirst.frc0.DanceBot1.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PlayTeleop extends Command
{
	public PlayTeleop()
	{
		requires(Robot.autoPlayer);
	}
	
    protected void initialize() 
    {
    	try
    	{
			Robot.autoPlayer.setupPlayback();
		} 
    	catch (FileNotFoundException e)
    	{
			e.printStackTrace();
		}
    }

    protected void execute() 
    {
    	Robot.autoPlayer.play();
    }

    protected boolean isFinished() 
    {
        return !Robot.autoPlayer.isPlaying();
    }

    protected void end() 
    {
    	Robot.autoPlayer.endPlayback();
    }

    protected void interrupted() 
    {
    	end();
    }
}
