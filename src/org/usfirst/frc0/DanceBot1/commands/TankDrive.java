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
    	Robot.driveTrain.move(0.0, 0.0);
    }

    protected void execute() 
    {
    	Robot.driveTrain.move(Robot.oi.getJoystick0Y(), Robot.oi.getJoystick0Y());
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
