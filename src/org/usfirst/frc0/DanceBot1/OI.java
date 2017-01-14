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
    
    public JoystickButton joystick0Button1;

    public OI() 
    {
        joystick0 = new Joystick(0);
        joystick1 = new Joystick(1);
        
        joystick0Button1 = new JoystickButton(joystick0, 1);
        joystick0Button1.whileHeld(new RotateLight());
        
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
}

