package org.usfirst.frc0.DanceBot1.subsystems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.usfirst.frc0.DanceBot1.Robot;
import org.usfirst.frc0.DanceBot1.RobotMap;
import org.usfirst.frc0.DanceBot1.commands.TestCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoPlayer extends Subsystem
{
    /*private final CANTalon leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final CANTalon lightMotor = RobotMap.lightRotaterMotor;*/
    
	Scanner scanner;
    
	boolean onTime;
	double nextTimestamp;
	boolean isPlaying;
	
	long startTime;
	
	//public static int autoNum = TeleopRecorder.autoNum;
	
	//public static String autoFile = new String("/home/lvuser/recordedAuto" + autoNum + ".csv");
	
	private boolean prevBool;
    
	public void setupPlayback() throws FileNotFoundException
	{
		isPlaying = true;
		
		startTime = System.currentTimeMillis();
		
		scanner = new Scanner(new File(Robot.autoFile));
		// lets the scanner know how to get separate values
		scanner.useDelimiter(",|\\n");
		
		onTime = true;
		
		prevBool = false;
	}
	
	public void play()
	{
		if((scanner != null) && (scanner.hasNextDouble()))
		{
			double deltaTime;
			
			if(onTime)
			{
				nextTimestamp = scanner.nextDouble();
			}
			
			deltaTime = nextTimestamp - (System.currentTimeMillis() - startTime);
			
			// if the current run time is equal to the timestamp of the motor values, set the motor values
			// this is so that the program doesn't set the values too fast
			if(deltaTime <= 0)
			{
				/*leftFrontMotor.set(scanner.nextDouble()); 
				leftRearMotor.set(scanner.nextDouble());
				rightFrontMotor.set(scanner.nextDouble());
				rightRearMotor.set(scanner.nextDouble());
				lightMotor.set(scanner.nextDouble());*/
				Robot.driveTrain.move(scanner.nextDouble(), scanner.nextDouble());
				Robot.lightRotater.move(scanner.nextDouble());
				// prevBool makes sure that the command is called only once
				if(scanner.nextBoolean())
				{
					if(!prevBool)
					{
						new TestCommand().start();
					}
					prevBool = true;
				}
				else
				{
					prevBool = false;
				}
				
				onTime = true;
			}
			else
			{
				// holds the program back until the run time matches the timestamp
				onTime = false;
			}
		}
		else
		{
			isPlaying = false;
		}
	}
	
	public void endPlayback()
	{
		/*leftFrontMotor.set(0);
		leftRearMotor.set(0);
		rightFrontMotor.set(0);
		rightRearMotor.set(0);
		lightMotor.set(0);*/
		
		if(scanner != null)
		{
			scanner.close();
			scanner = null;
		}
	}
	
	public boolean isPlaying()
	{
		return isPlaying;
	}
    
	protected void initDefaultCommand() 
	{
		
	}
}
