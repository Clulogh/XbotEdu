package competition.subsystems.drive.commands;

import javax.inject.Inject;

import xbot.common.command.BaseCommand;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;
import xbot.common.properties.DoubleProperty;

public class TurnLeft90DegreesCommand extends BaseCommand {

    DriveSubsystem drive;
    PoseSubsystem pose;

    double target;
    //double error;
    double previousPos = 0;
    double speeD;

    @Inject
    public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem, PoseSubsystem pose) {
        this.drive = driveSubsystem;
        this.pose = pose;

    }

    @Override
    public void initialize() {
        target = pose.getCurrentHeading().getDegrees() + 90; //90 is the target not the error
        //you need to reduce the +90, so it goes down as it gets closer to target. If it keeps +90 then it will pass the target


    }
    //circle is 360, 90 is one quarter of the circle, get degree is turning in place so no moving.

    @Override
    public void execute() {
        //turn 90 degrees instantly
        double power = pose.getCurrentHeading().getDegrees();
        double error = pose.getCurrentHeading().getDegrees() - previousPos;

        if (error < .001) {
            drive.tankDrive(1, speeD);

        double speed = pose.getCurrentHeading().getDegrees() - previousPos;
        double power = pose.getCurrentHeading().getDegrees() * error - previousPos * speed;




    }


}
