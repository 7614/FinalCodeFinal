package frc.robot.commands;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.commands.*;
/**
 *
 */
public class MoveArm extends Command {

    public MoveArm() {
        requires(Robot.arm);
        setTimeout(.9);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
         Robot.arm.teleopDrive(Robot.m_oi.getJoystick());
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        Robot.arm.stopElbow();
        Robot.arm.stopShoulder();
        Robot.arm.stopWrist();
    }

    protected void interrupted() {
    	end();
    }
}