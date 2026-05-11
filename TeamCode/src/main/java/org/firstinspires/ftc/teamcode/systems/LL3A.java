package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.hardware.limelightvision.Limelight3A;

import java.util.ArrayList;


public class LL3A {
    public static final double fovX=54.5, fovY=42., vw=Math.tan(fovX/2.),vh=Math.tan(fovY/2.);

    public static final ArrayList<LL3A> lllist=new ArrayList<>(1);

    Limelight3A ll;
    double xpos,ypos,zpos,xa,ya,za;
    /// relative to robot x is forwards, y up, z side
    public LL3A(double X, double Y, double Z, double xAngle, double yAngle,double zAngle) {
        set(X,Y,Z,xAngle,yAngle,zAngle);

        lllist.add(this);
    }
    public void set(double X, double Y, double Z,double xAngle,double yAngle,double zAngle){
        xpos=X;ypos=Y;zpos=Z;xa=xAngle;ya=yAngle;
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