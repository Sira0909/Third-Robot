package org.firstinspires.ftc.teamcode.Teleop;

import static org.firstinspires.ftc.teamcode.utils.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareRobot;
import org.firstinspires.ftc.teamcode.systems.Drive;
import org.firstinspires.ftc.teamcode.systems.DriveSubsystemNikolas;

@TeleOp(name = "wes")
public class wesTeleop extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        HardwareRobot robot = new HardwareRobot(hardwareMap);

        waitForStart();
        double x=0,y=0,t=0,targetAngle=0,angle=0,anglePrev=0;
        while(opModeIsActive()) {
            if (gamepad1.squareWasPressed()) {
            } else if (gamepad1.triangleWasPressed()) {
            } else if (gamepad1.circle) {

            } else if (gamepad1.cross) ;




            x=gamepad1.left_stick_y;
            y=gamepad1.left_stick_x;
            targetAngle+=gamepad1.right_stick_x/10.;

            drive.wheels.updMotion();
            anglePrev=angle;
            angle+=drive.wheels.motionT;

            t=.1*(targetAngle-angle)-.5*(angle-anglePrev);


            drive.local(-x, y, t);
        }
    }
}
