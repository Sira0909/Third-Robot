package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.arcrobotics.ftclib.hardware.ServoEx;
import org.firstinspires.ftc.teamcode.HardwareRobot;
import org.firstinspires.ftc.teamcode.systems.DriveSubsystemNikolas;
import org.firstinspires.ftc.teamcode.systems.LL3A;
import org.firstinspires.ftc.teamcode.systems.outtake.ArmSubsystemNikolas;
import org.firstinspires.ftc.teamcode.systems.outtake.ClawSubsystemNikolas;

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
        ClawSubsystemNikolas claw = new ClawSubsystemNikolas(robot.claw);
        ArmSubsystemNikolas arm = new ArmSubsystemNikolas(robot.arm, robot.wrist);
        LL3A limelight = new LL3A(robot);
        waitForStart();
        double f, s, t;
        while(opModeIsActive()) {
            f = -gamepad1.left_stick_y;
            s = gamepad1.left_stick_x;
            t = gamepad1.right_stick_x;

            drive.drivePowers(f, s, t);

            if (gamepad1.squareWasPressed()) {
                claw.toggle();
            }
            if (gamepad1.dpad_down) {
                arm.setArmPower(1);
            } else if (gamepad1.dpad_up) {
                arm.setArmPower(-1);
            } else {
                arm.setArmPower(0);
            }
            arm.setWristAngle(gamepad1.right_stick_y);

            limelight.getBlob();
        }
    }
}
