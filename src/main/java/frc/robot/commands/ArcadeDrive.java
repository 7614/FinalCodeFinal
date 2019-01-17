package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;


public class ArcadeDrive extends Command{

    public ArcadeDrive(){
        //this command will interupt any other command using the drive train
        requires(Robot.);
    }

    public static void driveForward(){
        
    }

    @Override
    protected boolean isFinished() {
        //the drive command should always be running: you should always
        //be able to push the joystick to move the robot
        return false;
    }

    @Override
    protected void execute(){
        //calls the function of the drive train, which will call an arcade drive method
        DriveTrain.TeleopDrive(Robot.m_oi.getJoystick());
    }

}
