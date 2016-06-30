package org.usfirst.frc5816.myRobot;

import org.usfirst.frc5816.myRobot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5816.myRobot.subsystems.*;

import org.usfirst.frc5816.myRobot.subsystems.*;

public class OI {

    public static JoystickButton solenoidButton;
    public static Joystick leftJoystick, rightJoystick, XboxController;
    public static boolean pressed;

    public OI() {
    	
    	XboxController = new Joystick(2);

        rightJoystick = new Joystick(1);
        
        leftJoystick = new Joystick(0);

    }

    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }
    
    public Joystick getXboxController() {
    	return XboxController;
    
    }
    
    

}

