package org.firstinspires.ftc.teamcode.subsytem;

import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DriveSubsystemNikolas {
    public final Motor frontLeft;
    public final Motor frontRight;
    public final Motor backLeft;
    public final Motor backRight;

    public DriveSubsystemNikolas(Motor fL, Motor fR, Motor bL, Motor bR) {
        frontLeft = fL;
        frontRight = fR;
        backLeft = bL;
        backRight = bR;
    }

    public void drivePowers(double forward, double strafe, double turn) {
        double flP = clamp(forward * Math.cos(), strafe * Math.sin(), turn);
        double frP = clamp(forward * Math.cos(), -strafe * Math.sin(), -turn);
        double blP = clamp(forward * Math.cos(), -strafe * Math.sin(), turn);
        double brP = clamp(forward * Math.cos(), strafe * Math.sin(), -turn); // Expected 1 argument but found 0

        //double max = Math.abs(forward) + Math.abs(strafe);
        
    }
    public double clamp(double f, double s, double t) {
        return Math.max(-1, Math.min(1, f+s+t));
    }
}
