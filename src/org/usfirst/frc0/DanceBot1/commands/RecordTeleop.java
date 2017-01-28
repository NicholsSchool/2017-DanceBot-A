package org.usfirst.frc0.DanceBot1.commands;

import java.io.IOException;

import org.usfirst.frc0.DanceBot1.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RecordTeleop extends Command
{
	public RecordTeleop()
	{
		requires(Robot.teleopRecorder);
	}
	
    protected void initialize() 
    {
    	Robot.isRecording = !Robot.isRecording;
    	
    	if(Robot.isRecording)
    	{
        	try 
        	{
    			Robot.teleopRecorder.setup();
    		} 
        	catch (IOException e) 
        	{
    			e.printStackTrace();
    		}
    	}
    }

    protected void execute() 
    {
    	if(Robot.isRecording)
    	{
        	try 
        	{
    			Robot.teleopRecorder.record();
    		} 
        	catch (IOException e) 
        	{
    			e.printStackTrace();
    		}
    	}
    }

    protected boolean isFinished() 
    {
        return !Robot.isRecording;
    }

    protected void end() 
    {
    	if(Robot.isRecording)
    	{
        	try
        	{
    			Robot.teleopRecorder.endRecord();
    		} 
        	catch (IOException e)
        	{
    			e.printStackTrace();
    		}
    	}
    }

    protected void interrupted() 
    {
    	end();
    }
}
