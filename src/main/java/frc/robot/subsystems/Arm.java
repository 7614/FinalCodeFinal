package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.MoveArm;

public class Arm extends Subsystem {

   // initialize arm motors
   private WPI_VictorSPX wrist = new WPI_VictorSPX(RobotMap.WRISTMOTOR);
   private WPI_VictorSPX elbow = new WPI_VictorSPX(RobotMap.ELBOWMOTOR);
   private WPI_VictorSPX shoulder = new WPI_VictorSPX(RobotMap.SHOULDERMOTOR);

   public double targetAngle;
   final public static double ARMSPEED = 1;

   public void initDefaultCommand() {
      setDefaultCommand(new MoveArm(0));
   }

   public void moveShoulder(double speed) {
      shoulder.set(speed * ARMSPEED);
   }

   public void stopShoulder() {
      shoulder.set(0);
   }

  
   public void moveElbow(double speed) {
      shoulder.set(speed * ARMSPEED);
   }

   public void stopElbow() {
      shoulder.set(0);
   }

   public void moveWrist(double speed) {
      shoulder.set(speed * ARMSPEED);
      
   }

   public void stopWrist() {
      shoulder.set(0);
   }

   

   
   

   // how to tell arm to move based on joystick??
}