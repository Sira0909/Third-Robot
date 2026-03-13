package org.firstinspires.ftc.teamcode.subsytem;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class MadisonDriveSubsys {
    public final Motor frontLeft;
    public final Motor frontRight;
    public final Motor backLeft;
    public final Motor backRight;

    public MadisonDriveSubsys(Motor fL, Motor fR, Motor bL, Motor bR) {
        this.frontLeft = fL;
        this.frontRight = fR;
        this.backLeft = bL;
        this.backRight = bR;
    }

    public void DriveRobotCentricPowers(double strafe, double forward, double turn) {
        frontLeft.set(forward + strafe + turn);
        frontRight.set(forward + strafe - turn);
        backLeft.set(forward - strafe - turn);
        backRight.set(forward - strafe + turn);

    }






}
