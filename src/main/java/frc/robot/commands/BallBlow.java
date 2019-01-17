package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class BallBlow extends Command{
    public BallBlow(){
        requires(Robot.ballIntake);
    }
    @Override
    protected boolean isFinished(){
        //just for now 
        return false;

    }
    @Override
    protected void execute(){
        Robot.ballIntake.backwardMotor1();
        Robot.ballIntake.forwardMotor2();
    }
}
