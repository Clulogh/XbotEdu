package competition.subsystems.drive.commands;

import javax.inject.Inject;

import competition.subsystems.pose.PoseSubsystem;
import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;

public class DriveToOrientationCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;
    double goal;
    double previousPos = 0;


    @Inject
    public DriveToOrientationCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;
    }

    public void setTargetHeading(double heading) {
        goal = heading; // heading= direction you want face in degrees
        // This method will be called by the test, and will give you a goal heading.
        if (goal > 180) {
            goal = goal - 360; //get the position between 0 to 180
        }
        // You'll need to remember this target position and use it in your calculations.
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // Here you'll need to figure out a technique that:
        // - Gets the robot to turn to the target orientation
        // - Gets the robot stop (or at least be moving really really slowly) at the target position
        //pose.getCurrentHeading(); //use current and goal/target & where you are facing rn
        //always turn to left,  but turn to right at some point
        double speed = pose.getCurrentHeading().getDegrees() - previousPos;
        double power = goal - speed;
        double error = pose.getCurrentHeading().getDegrees();

        // higher distance error higher power,more power less speed ||| power = error - speed
        drive.tankDrive(power, -power);
    }


    @Override
    public boolean isFinished() {
        // Modify this to return true once you have met your goal,
        // and you're moving fairly slowly (ideally stopped)
        return false;
    }
}
