package org.usfirst.frc5816.myRobot.subsystems;

import org.usfirst.frc5816.myRobot.OI;
import org.usfirst.frc5816.myRobot.Robot;
import org.usfirst.frc5816.myRobot.RobotMap;
import org.usfirst.frc5816.myRobot.commands.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

    private final SpeedController frontLeft = RobotMap.driveTrainFrontLeft;
    private final SpeedController backLeft = RobotMap.driveTrainBackLeft;
    private final SpeedController frontRight = RobotMap.driveTrainFrontRight;
    private final SpeedController backRight = RobotMap.driveTrainBackRight;
    private final RobotDrive driveTrain = RobotMap.driveTrainRobotDrive;
    
    public static void run() {

    }

    public void initDefaultCommand() {

        setDefaultCommand(new DriveWithJoysticks());

    }
    public void takeJoystickInputs(Joystick left, Joystick right)
    {
    	

    	if (OI.rightJoystick.getTrigger()) { 
			driveTrain.setMaxOutput(0.33);
		} else if (OI.leftJoystick.getTrigger()) { 
			driveTrain.setMaxOutput(1.0);
		} else {                                    
			driveTrain.setMaxOutput(0.66); 
		}

    	driveTrain.tankDrive(OI.leftJoystick, OI.rightJoystick);

    }

    public void stop()
    {
    	driveTrain.drive(0, 0);
    }
}

