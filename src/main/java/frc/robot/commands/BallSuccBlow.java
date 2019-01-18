package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class BallSuccBlow extends Command{
    public BallSuccBlow(){
        requires(Robot.ballIntake);
    }
    @Override
    protected boolean isFinished(){
        //just for now 
        return false;

    }
    @Override
    protected void execute(){
        Robot.ballIntake.teleopInTake(Robot.m_oi.getJoystick());
    }
}
