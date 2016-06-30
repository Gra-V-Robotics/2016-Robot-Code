package org.usfirst.frc5816.myRobot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5816.myRobot.commands.*;
import org.usfirst.frc5816.myRobot.subsystems.*;
import edu.wpi.first.wpilibj.Encoder;

public class Robot extends IterativeRobot {
	
	//Testing Git

	Command autonomousCommand;

	public static OI oi;
	public static DriveTrain driveTrain;
	public static AirCompressor airCompressor;
	private boolean runAuto;

	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		oi = new OI();

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {

	}

	public void autonomousInit() {
		runAuto = true;
		RobotMap.init();
	}

	public void autonomousPeriodic() {
		if (runAuto) {
			System.out.println("Starting Movement");
			RobotMap.driveTrainRobotDrive.drive(-0.65, 0.0);
			RobotMap.airCompressorSolenoid.set(true);
			Timer.delay(2.3);
			System.out.println("Stopping Movement");
			RobotMap.driveTrainRobotDrive.drive(0.0, 0.0);
			runAuto = false;
		}

	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		if (OI.XboxController.getRawAxis(2) > 0) {
    		RobotMap.airCompressorSolenoid.set(true);
    		RobotMap.intake.set(1.0);
    		System.out.println("Motor Forward Recieved");
    	} else if (OI.XboxController.getRawAxis(3) > 0) {
    		RobotMap.airCompressorSolenoid.set(true);
    		RobotMap.intake.set(-1.0);
    		System.out.println("Motor Backward Recieved");
    	} else if (OI.XboxController.getRawButton(5)) {
    		RobotMap.airCompressorSolenoid.set(true);
    	} else {
    		RobotMap.intake.set(0.0);
    		RobotMap.airCompressorSolenoid.set(false);
    		System.out.println("Motor Stop Recieved");
    	}
    	
    	if (OI.XboxController.getRawButton(5)) {
    		RobotMap.airCompressorSolenoid.set(true);
    	}
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
