package competition.subsystems.drive.commands;

import javax.inject.Inject;

import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;

public class DriveToPositionCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;

    @Inject
    public DriveToPositionCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;
    }

    public void setTargetPosition(double position) {
        // This method will be called by the test, and will give you a goal distance.
        // You'll need to remember this target position and use it in your calculations.
    }

    @Override
    public void initialize() {
        // If you have some one-time setup, do it here.
    }

    @Override
    public void execute() {
        //starts at 0, stops at 300. Slowly goes up by 1 (momentum) << we wanna remove it, so we can stop exactly on 300
        // Here you'll need to figure out a technique that:
        // - Gets the robot to move to the target position
        // - Gets the robot stop (or at least be moving really really slowly) at the target position
        //y=mx , power= p * error - d * speed d = deriative, speed = "velocity", error = displacement p, = proportion
        //if(isPrecisionModeActive) {
            //leftPower = leftPower * 0.1;
           // rightPower = rightPower * 0.1; //move very slowly to target positistion
        }
        //stop when you reach target
    }//cordinates or target/end position in the brackets

        drive.tankDrive(0.25,0.25);
        pose.getPosition();
    }

    @Override
    public boolean isFinished() {
        // Modify this to return true once you have met your goal,
        // and you're moving fairly slowly (ideally stopped)
        return false;
    }

}
