package competition.subsystems.drive.commands;

import javax.inject.Inject;

import competition.subsystems.pose.PoseSubsystem;
import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;

public class DriveToOrientationCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;
    double goal;

    @Inject
    public DriveToOrientationCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;
    }

    public void setTargetHeading(double heading) {
        goal = heading; // heading= direction you want face in degrees
        // This method will be called by the test, and will give you a goal heading.

        //if (target > 180) {
        //  target = target - 360; //get the position between 0 to 180

        // You'll need to remember this target position and use it in your calculations.
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // Here you'll need to figure out a technique that:
        // - Gets the robot to turn to the target orientation
        // - Gets the robot stop (or at least be moving really really slowly) at the
        // target position
        // pose. getcurrentheading = where you face rn
//always turn to left,  but turn to right at some point
        // How you do this is up to you. If you get stuck, ask a mentor or student for
        // some hints!
    }

    @Override
    public boolean isFinished() {
        // Modify this to return true once you have met your goal,
        // and you're moving fairly slowly (ideally stopped)
        return false;
    }
}
