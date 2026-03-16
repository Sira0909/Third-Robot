package org.firstinspires.ftc.teamcode.systems;

import org.firstinspires.ftc.teamcode.Pose2;
import org.firstinspires.ftc.teamcode.Vec2;

public class RPose extends Pose2{
    public final Vec2 norm=a;
    public RPose(){
        super(new Vec2(1,0));
    }
    public final Pose2 fieldPos=new Pose2(norm);
    public double dir=0;
    public void setDir(double angle){if(dir==(dir=angle))return;a.set(angle);}
    public void setDir(Vec2 v){if(a.equals(v))return;a.set(v);dir=a.angle();}
    public final Vec2 fieldVel = new Vec2();
    public final Vec2 localVel = new Vec2();
    public double rVel=0;

    public Vec2 pos(){return new Vec2(fieldPos);}
    public Pose2 pose2(){return new Pose2(fieldPos);}
    public Vec2 gVel(){return new Vec2(fieldVel);}
    public Vec2 lVel(){return new Vec2(localVel);}
}
