package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareRobot;
import org.firstinspires.ftc.teamcode.systems.DriveSubsystemNikolas;

@TeleOp(name = "nikolas")
public class NikolasTeleop extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        HardwareRobot robot = new HardwareRobot(hardwareMap);
        DriveSubsystemNikolas drive = new DriveSubsystemNikolas(
                robot.leftFront,
                robot.rightFront,
                robot.leftBack,
                robot.rightBack
        );
        waitForStart();
        double x=0,y=0,t=0;
        while(opModeIsActive()) {
            if (gamepad1.squareWasPressed()) {
            } else if (gamepad1.triangleWasPressed()) {
            } else if (gamepad1.circle) {
                drive.fr();
            } else if (gamepad1.cross) {
                drive.br();
            } else {
//
                x=gamepad1.left_stick_y;
                y=gamepad1.left_stick_x;
                t=gamepad1.right_stick_x;


                drive.drivePowers(-x, y, t);
            }
        }
    }
}
