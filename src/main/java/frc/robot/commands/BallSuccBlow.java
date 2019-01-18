package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class BallSuccBlow extends Command{

    int succBlowMode;
    public BallSuccBlow(int mode){
        requires(Robot.ballIntake);
        this.succBlowMode=mode;
    }
    @Override
    protected boolean isFinished(){
        //just for now 
        return false;

    }
    @Override
    protected void execute(){
        if(this.succBlowMode==1){
            Robot.ballIntake.backwardMotor1();
            Robot.ballIntake.forwardMotor2();
        }else if(this.succBlowMode==-1){
            Robot.ballIntake.backwardMotor2();
            Robot.ballIntake.forwardMotor1();
        }
    }
}
