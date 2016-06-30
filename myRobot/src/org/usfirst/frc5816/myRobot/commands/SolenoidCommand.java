//<<<<<<< HEAD
/*package org.usfirst.frc5816.myRobot.commands;
=======
package org.usfirst.frc5816.myRobot.commands;
>>>>>>> parent of 40e182e... POSSIBLY WORKING

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5816.myRobot.OI;
import org.usfirst.frc5816.myRobot.Robot;
import org.usfirst.frc5816.myRobot.RobotMap;
import org.usfirst.frc5816.myRobot.subsystems.AirCompressor;

public class SolenoidCommand extends Command {
	

    public SolenoidCommand() {

        requires(Robot.airCompressor);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
     //Runs once on button press 
    	if(OI.pressed == true){   		// Checks if pressed equals true
    		RobotMap.airCompressorSolenoid.set(true); // Set the solenoid to true
    		OI.pressed = false; // change pressed value 
    	}
    	else if(OI.pressed == false){ 
    		RobotMap.airCompressorSolenoid.set(false);
    		OI.pressed = true;
    	}   	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
*/