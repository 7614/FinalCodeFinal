package frc.robot.commands;

import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.commands.*;

/**
 *
 */
public class MoveArm extends Command {

    int liftSpeed;
    public MoveArm(int liftSpeed) {
        this.liftSpeed=liftSpeed;
        requires(Robot.arm);
        setTimeout(.9);
    }

    protected void initialize() {

    }

    protected void execute() {
        armControl(liftSpeed);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        Robot.arm.stopElbow();
        Robot.arm.stopShoulder();
        Robot.arm.stopWrist();
    }

    public void armControl(double liftSpeed) {
        Robot.arm.moveShoulder(liftSpeed);
        Robot.arm.moveElbow(liftSpeed);
        Robot.arm.moveWrist(liftSpeed);
    }

    protected void interrupted() {
        end();
    }
}