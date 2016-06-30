package org.usfirst.frc5816.myRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5816.myRobot.Robot;
import org.usfirst.frc5816.myRobot.RobotMap;

public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {

        requires(Robot.driveTrain);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.driveTrain.takeJoystickInputs(Robot.oi.getLeftJoystick(), Robot.oi.getRightJoystick());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    	//RobotMap.intake.stopMotor();
    }

    protected void interrupted() {
    	end();
    }
}
