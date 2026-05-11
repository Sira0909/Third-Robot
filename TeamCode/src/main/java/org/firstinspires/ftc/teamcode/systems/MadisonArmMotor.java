package org.firstinspires.ftc.teamcode.systems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;

public class MadisonArmMotor{
    public final Motor armMotor;
    public final Servo armServo;

    public MadisonArmMotor(Motor aMotor, Servo aServo) {
        armMotor = aMotor;
        armServo = aServo;

    }

    public void armPower(double power){

    }


}
