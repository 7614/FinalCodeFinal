package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchPiston extends Subsystem {
   //Initialize Solenoid objects (each individual piston)
  Solenoid sol1 = new Solenoid(0);
    Solenoid sol2 = new Solenoid(1); //Solenoid ID values assumed; may be different
  
    @Override
    public void initDefaultCommand() {
      
    }

    public void pushHatch() {
      sol1.set(true);
      sol2.set(true); //Pressurise 
      
    
      //Need command to give pistons time to extend


      sol1.set(false);
      sol2.set(false); //Depressurise
    }
  }
  