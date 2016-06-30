/*package org.usfirst.frc5816.myRobot.commands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc5816.myRobot.Robot;
import org.usfirst.frc5816.myRobot.RobotMap;

public class AutonomousCommand extends Command {
	
	public static long timeout;

	public static Timer time;


    public AutonomousCommand() {
    	
        requires(Robot.driveTrain);

        //time.reset();
        //time.start();
    	
    }
    
    public void autonomousInit() {
    	
    }
    
    public void autonomousPeriodic() {
    }

    protected void initialize() {

    	 
    }

    protected void execute() {
    		RobotMap.driveTrainRobotDrive.drive(-0.65, 0.0);
    	

    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
*/