package org.usfirst.frc0.DanceBot1.commands;

import java.io.IOException;

import org.usfirst.frc0.DanceBot1.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RecordTeleop extends Command
{
    protected void initialize() 
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

    protected void execute() 
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

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
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

    protected void interrupted() 
    {
    	end();
    }
}
