package org.usfirst.frc0.DanceBot1.subsystems;

import org.usfirst.frc0.DanceBot1.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoSwitch extends Subsystem {
	
	private double autoSwitch = RobotMap.switchPot.get();
	
	private final double dials = 11;
	
	public double getDial() {
	   
	   double dialNum = autoSwitch/(autoSwitch/dials);
	   double floor = Math.floor(dialNum);
	   
	   if ((dialNum - floor) >= 0.5)
	   {
		  dialNum =  Math.ceil(dialNum);
	   }
	   else if((dialNum - floor) < 0.5)
	   {
		   dialNum = floor;
	   }
	   
	   return dialNum;

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
