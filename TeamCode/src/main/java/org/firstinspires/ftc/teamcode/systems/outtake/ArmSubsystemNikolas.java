package org.firstinspires.ftc.teamcode.systems.outtake;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmSubsystemNikolas {
    public final Motor armMotor;
    public final Servo wristServo;

    public ArmSubsystemNikolas(Motor armM, Servo wristS) {
        armMotor = armM;
        wristServo = wristS;
    }

    public void setArmPower(double power) {
        armMotor.set(power);
    }
    public void setWristAngle(double angle) {
        wristServo.setPosition(angle);
    }
}
