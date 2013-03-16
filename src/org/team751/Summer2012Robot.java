package org.team751;


import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Summer2012Robot extends IterativeRobot {
    
    private Joystick driveStick = new Joystick(1);
    
    private RobotDrive drive;
    
    private CANJaguar leftA, leftB, rightA, rightB;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        try {
            leftA = new CANJaguar(4);
            leftB = new CANJaguar(3);
            
            rightA = new CANJaguar(2);
            rightB = new CANJaguar(1);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        drive = new RobotDrive(leftA, leftB, rightA, rightB);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        drive.arcadeDrive(-driveStick.getY(), -driveStick.getX(), true);
    }
}
