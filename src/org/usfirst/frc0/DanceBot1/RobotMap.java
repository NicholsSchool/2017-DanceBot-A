package org.usfirst.frc0.DanceBot1;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap 
{
    public static CANTalon driveTrainLeftFrontMotor;
    public static CANTalon driveTrainLeftRearMotor;
    public static CANTalon driveTrainRightFrontMotor;
    public static CANTalon driveTrainRightRearMotor;
    public static RobotDrive driveTrainRobotDrive4;
    public static CANTalon lightRotaterMotor;

    public static Encoder rightEncoder;
    public static Encoder leftEncoder;
    
    public static AnalogPotentiometer testPot;
    public static AnalogPotentiometer switchPot;
    
    public static void init() 
    {
        driveTrainLeftFrontMotor = new CANTalon(23);
        LiveWindow.addActuator("Drive Train", "Left Front Motor", driveTrainLeftFrontMotor);
        
        driveTrainLeftRearMotor = new CANTalon(24);
        LiveWindow.addActuator("Drive Train", "Left Rear Motor", driveTrainLeftRearMotor);
        
        driveTrainRightFrontMotor = new CANTalon(21);
        LiveWindow.addActuator("Drive Train", "Right Front Motor", driveTrainRightFrontMotor);
        
        driveTrainRightRearMotor = new CANTalon(22);
        LiveWindow.addActuator("Drive Train", "Right Rear Motor", driveTrainRightRearMotor);
        
        driveTrainRobotDrive4 = new RobotDrive(driveTrainLeftFrontMotor, driveTrainLeftRearMotor,
              driveTrainRightFrontMotor, driveTrainRightRearMotor);
        
        driveTrainRobotDrive4.setSafetyEnabled(true);
        driveTrainRobotDrive4.setExpiration(0.1);
        driveTrainRobotDrive4.setSensitivity(0.5);
        driveTrainRobotDrive4.setMaxOutput(1.0);

        lightRotaterMotor = new CANTalon(25);
        LiveWindow.addActuator("Light Rotater", "Motor", lightRotaterMotor);
        
        //rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        //leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    
       // testPot = new AnalogPotentiometer(0, 1, 0);
        switchPot = new AnalogPotentiometer(0, 360, 0);
    }
}
