package org.usfirst.frc0.DanceBot1.subsystems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.usfirst.frc0.DanceBot1.Robot;
import org.usfirst.frc0.DanceBot1.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TeleopRecorder extends Subsystem
{
    private final CANTalon leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final CANTalon lightMotor = RobotMap.lightRotaterMotor;
	
	FileWriter writer;
	
	long startTime;
	
	static final int autoNum = 1;
	
	public static final String autoFile = new String("/home/lvuser/recordedAuto" + autoNum + ".csv");
	
	public void setupRecorder() throws IOException
	{
		startTime = System.currentTimeMillis();
		
		writer = new FileWriter(autoFile);
	}
	
	public void record() throws IOException
	{
		// write a time stamp, the motor values, and make a new line
		if(writer != null)
		{
			writer.append("" + (System.currentTimeMillis() - startTime));
			
			writer.append("," + leftFrontMotor.get());
			writer.append("," + leftRearMotor.get());
			writer.append("," + rightFrontMotor.get());
			writer.append("," + rightRearMotor.get());
			writer.append("," + lightMotor.get());
			
			writer.append("\n");
		}
	}
	
	public void endRecord() throws IOException
	{
		if(writer != null)
		{
			writer.flush();
			writer.close();
		}
	}
	
	protected void initDefaultCommand()
	{
		
	}
}
