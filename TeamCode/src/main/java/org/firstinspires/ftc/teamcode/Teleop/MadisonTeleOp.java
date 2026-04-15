package org.firstinspires.ftc.teamcode.Teleop;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareRobot;
import org.firstinspires.ftc.teamcode.systems.MadisonDriveSubsys;

@TeleOp(name = "madisonTeleOp")
public class MadisonTeleOp extends LinearOpMode{

    public void runOpMode() throws InterruptedException{

        HardwareRobot robot = new HardwareRobot(hardwareMap);
        MadisonDriveSubsys drive = new MadisonDriveSubsys(
                robot.leftFront,
                robot.rightFront,
                robot.leftBack,
                robot.rightBack
        );
        waitForStart();
        while(opModeIsActive()) {
            drive.DriveRobotCentricPowers(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }

    }






}
