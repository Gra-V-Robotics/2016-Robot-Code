package org.usfirst.frc5816.myRobot.subsystems;

import org.usfirst.frc5816.myRobot.RobotMap;
import org.usfirst.frc5816.myRobot.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AirCompressor extends Subsystem {

    private final Compressor compressor = RobotMap.airCompressorCompressor;

    public void initDefaultCommand() {

        setDefaultCommand(new StartCompression());
    }
    

	public void start()
    {
		compressor.start();
    }
	
    
}

