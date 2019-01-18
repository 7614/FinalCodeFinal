package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {
    // we should initialize all drive motorcontrollers here:
    // left motors + speed controller group
    private WPI_VictorSPX leftFront = new WPI_VictorSPX(RobotMap.FRONTLEFTMOTOR);
    private WPI_VictorSPX leftBack = new WPI_VictorSPX(RobotMap.BACKLEFTMOTOR);
    // groups the two left motors together
    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(leftFront, leftBack);
    // right motors + speed controller group
    private WPI_VictorSPX rightFront = new WPI_VictorSPX(RobotMap.FRONTRIGHTMOTOR);
    private WPI_VictorSPX rightBack = new WPI_VictorSPX(RobotMap.BACKRIGHTMOTOR);
    // groups the right motors together, so they can be controlled in sync
    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(rightFront, rightBack);

    // Connects the left an right motor controller groups to make a drive train
    DifferentialDrive base_drive = new DifferentialDrive(leftGroup, rightGroup); // takes inputs of 2 motor controller
                                                                                 // groups

    @Override
    protected void initDefaultCommand() {
        // whenever the drive train is not running a command, ArcadeDrive will be added
        // to the scheduler
        setDefaultCommand(new ArcadeDrive());
    }

    /**
     * Method of the drive train, takes in an xbox controller in order to drive.
     * Currently, inputs are being squared.
     * 
     * @param xbox the xbox controller, only one joystick is used
     */
    public void teleopDrive(XboxController xbox) {
        // tells the drive train to drive based on a joystick
        // the first parameter is speed, the second angle of turn
        // the third parameter enables squared inputs, which "decreases sensitivity at
        // low speeds"
        base_drive.arcadeDrive(xbox.getY(), xbox.getX(), true);
    }
}