package org.usfirst.frc5816.myRobot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc5816.myRobot.commands.*;
import org.usfirst.frc5816.myRobot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;

public class Robot extends IterativeRobot {
	
    SpeedController frontLeft;
    SpeedController backLeft;
    SpeedController frontRight;
    SpeedController backRight;
    SpeedController intakeMotor;
    RobotDrive driveTrain;
    Compressor compressor;
    Solenoid intakeSolenoid;
    Joystick leftJoystick;
    Joystick rightJoystick;
    Joystick XboxController;

	boolean runAuto;
    double intakeSpeed;
    double autoDriveSpeed;
    double curve;
    double slowTrigger;
    double defaultDrive;
    double fastTrigger;

	public void robotInit() {

        frontLeft = new VictorSP(0);
        backLeft = new VictorSP(1);       
        frontRight = new VictorSP(2);
        backRight = new VictorSP(3);
        intakeMotor = new VictorSP(4);
        compressor = new Compressor(0);
        intakeSolenoid = new Solenoid(0);

        
        driveTrain = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
        
        driveTrain.setSafetyEnabled(false);
        driveTrain.setExpiration(0.1);
        driveTrain.setSensitivity(0.5);
        driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
        
    	XboxController = new Joystick(2);

        rightJoystick = new Joystick(1);
        
        leftJoystick = new Joystick(0);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {

	}

	public void autonomousInit() {
		runAuto = true;
		autoDriveSpeed = 0.65;
		curve = 0.0;
	}

	public void autonomousPeriodic() {
		if (runAuto) {
			System.out.println("Starting Movement");
			driveTrain.drive(autoDriveSpeed, curve);
			intakeSolenoid.set(true);
			Timer.delay(2.3);
			System.out.println("Stopping Movement");
			driveTrain.drive(0.0, 0.0);
			runAuto = false;
		}

	}

	public void teleopInit() {

		slowTrigger = 0.33;
		defaultDrive = 0.66;
		fastTrigger = 1.0;
		intakeSpeed = 1.0;
		
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
    	driveTrain.tankDrive(leftJoystick, rightJoystick);
		
		if (XboxController.getRawAxis(2) > 0.2) {
    		intakeSolenoid.set(true);
    		intakeMotor.set(intakeSpeed);
    		System.out.println("Motor Forward Recieved");
    	} else if (XboxController.getRawAxis(3) > 0.2) {
    		intakeSolenoid.set(true);
    		intakeMotor.set(-intakeSpeed);
    		System.out.println("Motor Backward Recieved");
    	} else if (XboxController.getRawButton(5)) {
    		intakeSolenoid.set(true);
    	} else {
    		intakeMotor.set(0.0);
    		intakeSolenoid.set(false);
    		System.out.println("Motor Stop Recieved");
    	}
    	
    	if (XboxController.getRawButton(5)) {
    		intakeSolenoid.set(true);
    	}
    	
    	if (leftJoystick.getTrigger()) {
    		driveTrain.setMaxOutput(slowTrigger);
    	} else if (rightJoystick.getTrigger()) {
    		driveTrain.setMaxOutput(fastTrigger);
    	} else {
    		driveTrain.setMaxOutput(defaultDrive);
    	}
    	
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
