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
        double flP = clamp(forward, strafe, turn);
        double frP = clamp(forward, -strafe, -turn);
        double blP = clamp(forward, -strafe, turn);
        double brP = clamp(forward, strafe, -turn);

        //double max = Math.abs(forward) + Math.abs(strafe);
        
    }
    public double clamp(double f, double s, double t) {
        return Math.max(-1, Math.min(1, f+s+t));
    }
}
