package org.usfirst.frc.team1.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1.robot.Robot;
/**
 *
 */
public class MoveArm extends Command {

    public MoveArm() {
        requires(Robot.Arm);
        setTimeout(.9);
    }

    protected void initialize() {
    	Robot.arm.move()
    }

    protected void execute() {
         Arm.TeleopDrive(Robot.m_oi.getJoystick());
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.Arm.stop();
    }

    protected void interrupted() {
    	end();
    }
}