package org.usfirst.frc0.DanceBot1;

import org.usfirst.frc0.DanceBot1.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc0.DanceBot1.subsystems.*;

public class OI 
{
    public Joystick joystick0;
    public Joystick joystick1;
    public Joystick joystick2;
    
    public JoystickButton joystick0Button7;
    public JoystickButton joystick0Button8;
    public JoystickButton joystick0Button10;

    public OI() 
    {
        joystick0 = new Joystick(0);
        joystick1 = new Joystick(1);
        joystick2 = new Joystick(2);
        
        joystick0Button7 = new JoystickButton(joystick0, 7);
        joystick0Button7.whenPressed(new RecordTeleop());
        
        joystick0Button8 = new JoystickButton(joystick0, 8);
        joystick0Button8.whenPressed(new StopRecord());
        
        joystick0Button10 = new JoystickButton(joystick0, 10);
        joystick0Button10.whenPressed(new PlayTeleop());
        
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Tank Drive", new TankDrive());
        SmartDashboard.putData("Rotate Light", new RotateLight());
    }
    
    public Joystick getJoystick0()
    {
        return joystick0;
    }

    public Joystick getJoystick1() 
    {
        return joystick1;
    }
    
    public double getJoystick0Y()
    {
    	// return is negative b/c the joystick has reversed values
    	return -joystick0.getY();
    }
    
    public double getJoystick0X()
    {
    	return -joystick0.getX();
    }
    
    public double getJoystick1Y() 
    {
    	return -joystick1.getY();
    }
    public double getJoystick0Z()
    {
    	return joystick0.getZ();
    }
    
    public double getJoystick2()
    {
    	return joystick2.getY();
    }
}

