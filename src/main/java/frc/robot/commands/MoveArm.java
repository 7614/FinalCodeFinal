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

    int liftState;
    public MoveArm(int liftState) {
        this.liftState=liftState;
        requires(Robot.arm);
        requires(Robot.potentiometer);
        
        setTimeout(.9);
    }

    protected void initialize() {

    }

    protected void execute() {
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
        if(liftState == 1){
            //move up
            if(Robot.potentiometer.get<360){

            }
        }else if (liftState == -1){

        }
    }

    protected void interrupted() {
        end();
    }
}