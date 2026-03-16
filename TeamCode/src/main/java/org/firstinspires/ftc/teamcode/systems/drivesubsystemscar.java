package org.firstinspires.ftc.teamcode.systems;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class drivesubsystemscar {
    public final Motor frontLeft;
    public final Motor frontRight;
    public final Motor backLeft;
    public final Motor backRight;

    public drivesubsystemscar(Motor fL, Motor bL, Motor bR, Motor fR) {
        this.frontLeft = fL;
        this.frontRight = fR;
        this.backLeft = bL;
        this.backRight = bR;
    }

    public void driverobotcentricpowers(double strafe, double forward, double turn)
    {
        frontLeft.set(forward+strafe+turn);
        frontRight.set(forward-strafe-turn);
        backLeft.set(forward-strafe+turn);
        backRight.set(forward+strafe-turn);
    }
    public double clamp(double f, double s, double t) {
        return Math.max(-1, Math.min(1, f+s+t));
    }
}