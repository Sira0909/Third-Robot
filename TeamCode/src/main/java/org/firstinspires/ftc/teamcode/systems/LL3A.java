package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.teamcode.HardwareRobot;

import java.util.List;


public class LL3A {
    private final double HEIGHT = 1;
    public static final double fovX=54.5, fovY=42., vw=Math.tan(fovX/2.),vh=Math.tan(fovY/2.);
    private Limelight3A limelight;
    List<LLResultTypes.ColorResult> blobs;

    double xpos,ypos,zpos,xa,ya,za;
    /// relative to robot x is forwards, y up, z side
    public LL3A(HardwareRobot hardwaremap) {
        limelight = hardwaremap.limelight;
    }
    public void set(double X, double Y, double Z,double xAngle,double yAngle,double zAngle){
        xpos=X;ypos=Y;zpos=Z;xa=xAngle;ya=yAngle;
    }

    public LLResultTypes.ColorResult getBlob() {
        LLResult result = limelight.getLatestResult();
        blobs = result.getColorResults();
        LLResultTypes.ColorResult biggest = blobs.get(0);
        double area = 0;
        for (LLResultTypes.ColorResult blob : blobs) {
            if (blob.getTargetArea() > area) {
                area = blob.getTargetArea();
                biggest = blob;
            }
        }
        return biggest;
    }
    public double getDist() {
        LLResultTypes.ColorResult blob = getBlob();
        return HEIGHT/(Math.tan(blob.getTargetYDegrees()));
    }



}




/*
                        I/O: USB-C
                     Sensor: OV5647 Color Rolling Shutter
Color; Pipeline Performance: 90fps @ 640x480
       AprilTag Performance: 20fps @ 1280x960, 2x downscale  50fps @ 640x480, 2x downscale
                     Weight: .20 lb
                        FOV: H:54.5° V:42°
	                         4W max
                             2.839in x 1.894in | 72.11mm x 48.11mm, 0.661in | 16.80 mm thick max
 */