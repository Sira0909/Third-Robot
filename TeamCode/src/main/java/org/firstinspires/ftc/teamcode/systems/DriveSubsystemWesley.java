package org.firstinspires.ftc.teamcode.systems;

import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DriveSubsystemWesley {
    public final Motor frontLeft;
    public final Motor frontRight;
    public final Motor backLeft;
    public final Motor backRight;
    public double multiplier = .5;

    public DriveSubsystemWesley(Motor fL, Motor fR, Motor bL, Motor bR) {
        frontLeft = fL;
        frontRight = fR;
        backLeft = bL;
        backRight = bR;
    }
    public void fl(){
        frontLeft.set(.3);
    }
    public void bl(){
        backLeft.set(.3);
    }
    public void fr(){
        frontRight.set(.3);
    }
    public void br(){
        backRight.set(.3);
    }
    public void drivePowers(double forward, double strafe, double turn) {
        double flP = multiplier*clamp(forward, strafe, turn);
        double frP = multiplier*clamp(forward, -strafe, -turn);
        double blP = multiplier*clamp(forward, -strafe, turn);
        double brP = multiplier*clamp(forward, strafe, -turn);

        frontLeft.set(flP);
        frontRight.set(frP);
        backLeft.set(blP);
        backRight.set(brP);

        //double max = Math.abs(forward) + Math.abs(strafe);
        
    }
    public void driveFieldCentric(double forward, double strafe, double turn, double angle) {
        double angleTo = Math.atan(strafe/forward);
        double angleOffset = angleTo - angle;

        forward = Math.cos(angleOffset);
        strafe = Math.sin(angleOffset);

        double flP = clamp(forward, strafe, turn);
        double frP = clamp(forward, -strafe, -turn);
        double blP = clamp(forward, -strafe, turn);
        double brP = clamp(forward, strafe, -turn);

        frontLeft.set(flP);
        frontRight.set(frP);
        backLeft.set(blP);
        backRight.set(brP);

    }

    public double clamp(double f, double s, double t) {
        return Math.max(-1, Math.min(1, f+s+t));
    }
}
