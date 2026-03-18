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
                robot.leftFront;
                robot.rightFront;



        );
    }
}
