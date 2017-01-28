package org.usfirst.frc0.DanceBot1.subsystems;

import java.io.FileWriter;
import java.io.IOException;

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
	
	static final String autoFile = "***insert the path of the file you want to record to here***";
	
	public void setup() throws IOException
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
	
	public void play()
	{
		
	}

	protected void initDefaultCommand()
	{
		
	}
}
