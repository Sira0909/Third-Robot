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
        double f = 0,s = 0,t = 0;
        while(opModeIsActive()) {
            f = -gamepad1.left_stick_y;
            s = gamepad1.left_stick_x;
            t = gamepad1.right_stick_x;

            drive.drivePowers(f, s, t);
        }
    }
}
