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
        while(opModeIsActive()) {
            if (gamepad1.square) {
                drive.fl();
            } else if (gamepad1.triangle) {
                drive.bl();
            } else if (gamepad1.circle) {
                drive.fr();
            } else if (gamepad1.cross) {
                drive.br();
            } else {
                drive.drivePowers(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            }
        }
    }
}
