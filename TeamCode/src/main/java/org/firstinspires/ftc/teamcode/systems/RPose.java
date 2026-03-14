package org.firstinspires.ftc.teamcode.systems;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Pose2;
import org.firstinspires.ftc.teamcode.Vec2;

public class RPose {
    public static final Vec2 norm=new Vec2(1,0);
    public static final Pose2 globalPos=new Pose2(norm);
    public static double angle=0;
    public static final Vec2 globalVel = new Vec2();
    public static final Vec2 localVel = new Vec2();
    public static double rVel=0;

    public static Vec2 pos(){return new Vec2(globalPos);}
    public static Pose2 pose2(){return new Pose2(globalPos);}
    public static Vec2 gVel(){return new Vec2(globalVel);}
    public static Vec2 lVel(){return new Vec2(localVel);}
}
