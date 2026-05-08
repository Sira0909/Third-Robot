package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.arcrobotics.ftclib.hardware.ServoEx;
import org.firstinspires.ftc.teamcode.HardwareRobot;
import org.firstinspires.ftc.teamcode.systems.DriveSubsystemNikolas;
import org.firstinspires.ftc.teamcode.systems.outtake.ArmSubsystemNikolas;
import org.firstinspires.ftc.teamcode.systems.outtake.ClawSubsystemNikolas;

@TeleOp(name = "wes")
public class wesTeleop extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        HardwareRobot robot = new HardwareRobot(hardwareMap);
        DriveSubsystemNikolas drive = new DriveSubsystemNikolas(
                robot.leftFront,
                robot.rightFront,
                robot.leftBack,
                robot.rightBack
        );
        ClawSubsystemNikolas claw = new ClawSubsystemNikolas(robot.claw);
        ArmSubsystemNikolas arm = new ArmSubsystemNikolas(robot.arm, robot.wrist);
        waitForStart();
        double f, s, t,
        armTargetPos=0,
        lastArmPos=0,
        lastTime=0;

        while(opModeIsActive()) {
            double time=1.e-9*System.nanoTime();
            double dt=(time-lastTime);
            lastTime=time;

            f = -gamepad1.left_stick_y;
            s = gamepad1.left_stick_x;
            t = gamepad1.right_stick_x;

            drive.drivePowers(f, s, t);

            if (gamepad1.squareWasPressed()) {
                claw.toggle();
            }


            double armPos=arm.armMotor.getCurrentPosition();
            double armRate=dt*(armPos-lastArmPos);
            lastArmPos=armPos;

            double armError=armTargetPos-armPos;

            arm.setArmPower(-2.*armRate+1*armError);

            if (gamepad1.dpad_down) {
                armTargetPos+=dt;
            } else if (gamepad1.dpad_up) {
                armTargetPos-=dt;
            }
        }
    }
}
