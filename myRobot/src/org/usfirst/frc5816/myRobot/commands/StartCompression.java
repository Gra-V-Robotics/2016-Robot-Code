package org.usfirst.frc5816.myRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5816.myRobot.Robot;

public class StartCompression extends Command {

    public StartCompression() {

        requires(Robot.airCompressor);

    }

    protected void initialize() {
    	Robot.airCompressor.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
