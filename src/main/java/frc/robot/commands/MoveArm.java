package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.PIDInterface;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.*;
import frc.robot.commands.*;

/**
 *
 */
public class MoveArm extends Command {

    //direction that the angle will move towards;
    int angleMoveDir;
   
    public MoveArm(int angleMoveDir) {
        this.angleMoveDir=angleMoveDir;
        requires(Robot.arm);
        requires(Robot.potentiometer);
        
        setTimeout(.9);
    }


   
    protected void initialize() {

    }

    protected void execute() {
        Robot.arm.targetAngle+=this.angleMoveDir;
        armControl();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        Robot.arm.stopElbow();
        Robot.arm.stopShoulder();
        Robot.arm.stopWrist();
    }

    public void armControl() {
        //PID MIGHT BE REQUIRED LOL
        if((Robot.potentiometer.getShoulderRotDegrees()<Robot.arm.targetAngle)&&(!Robot.limitSwitch.shoulderIsMax())){
            Robot.arm.moveShoulder(1);
        }else if(Robot.potentiometer.getShoulderRotDegrees()>Robot.arm.targetAngle){
            Robot.arm.moveShoulder(-1);
        }

        if((Robot.potentiometer.getElbowRotDegrees()<Robot.arm.targetAngle)&&(!Robot.limitSwitch.elbowisMax())){
            Robot.arm.moveElbow(1);
        }else if(Robot.potentiometer.getElbowRotDegrees()>Robot.arm.targetAngle){
            Robot.arm.moveElbow(-1);
        }


    }

    protected void interrupted() {
        end();
    }
}