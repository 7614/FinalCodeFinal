package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class BallSucc extends Command{
    public BallSucc(){
        requires(Robot.ballIntake);
    }
    
    
    @Override
    protected boolean isFinished(){
        //just for now
        return false;
    }
    @Override
    protected void execute(){
        Robot.ballIntake.forwardMotor1();
        Robot.ballIntake.backwardMotor2();
    }
}
