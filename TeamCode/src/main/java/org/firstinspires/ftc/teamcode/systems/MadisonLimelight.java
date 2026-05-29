package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;

public class MadisonLimelight {

    Limelight3A limelight;
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();

        limelight.pipelineSwitch(0);

        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
            double tx = result.getTx();
            double ty = result.getTy();
            double ta = result.getTa();

            telemetry.addData("x", tx);
            telemetry.addData("y", ty);
            telemetry.addData("size", ta);
        } else {
            telemetry.addData("Limelight ", "No target");
        }
    }






}
