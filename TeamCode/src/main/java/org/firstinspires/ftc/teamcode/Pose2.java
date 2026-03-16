package org.firstinspires.ftc.teamcode;

public class Pose2 extends Vec2{
    public final Vec2 a;
    public Vec2 v(){return this;}
    public Pose2 (){a=new Vec2(1,0);}
    public Pose2 (double angle){a=new Vec2(angle);}
    public Pose2 (Vec2 angle){a=new Vec2(angle);}
    public Pose2 (double angleX, double angleY){a=new Vec2(angleX, angleY);}
    public Pose2 (double X, double Y, double angle){super(X,Y);a=new Vec2(angle);}
    public Pose2 (Vec2 v, double angle){super(v);a=new Vec2(angle);}
    public Pose2 (Vec2 v, Vec2 angle){super(v);a=new Vec2(angle);}
    public Pose2 set(Vec2 v,double angle){set(v);a.set(angle);return this;}
    public Pose2 set(Vec2 v,Vec2 angle){set(v);a.set(angle);return this;}
    public Pose2 set(double X,double Y,double angle){set(X,Y);a.set(angle);return this;}
    public Pose2 set(double X,double Y,Vec2 angle){set(X,Y);a.set(angle);return this;}
    public Pose2 set(double X,double Y,double angleX, double angleY){set(X,Y);a.set(angleX,angleY);return this;}
    public Pose2 set(Pose2 p){super.set(p); a.set(p.a); return this;}
    public Pose2 add(double X,double Y,double angle){x+=X;y+=Y;a.rot(angle);return this;}
    public Pose2 add(double X,double Y,double angleX, double angleY){x+=X;y+=Y;a.rot(angleX,angleY);return this;}
    public Pose2 add(Vec2 v,double angle){add(v);a.rot(angle);return this;}
    public Pose2 add(Vec2 v,Vec2 angle){add(v);a.rot(angle);return this;}
    public Pose2 add(Vec2 v,double angleX, double angleY){add(v);a.rot(angleX,angleY);return this;}
    public Pose2 subt(double X,double Y,double angle){x-=X;y-=Y;a.rot(-angle);return this;}
    public Pose2 subt(double X,double Y,double angleX, double angleY){x-=X;y-=Y;a.rotN(angleX,angleY);return this;}
    public Pose2 subt(Vec2 v,double angle){subt(v);a.rot(-angle);return this;}
    public Pose2 subt(Vec2 v,Vec2 angle){subt(v);a.rotN(angle);return this;}
    public Pose2 subt(Vec2 v,double angleX, double angleY){subt(v);a.rotN(angleX,angleY);return this;}

    @Override public Vec2 toLocal(Pose2 p) {a.rotN(p.a);return super.toLocal(p);}
    @Override public Vec2 fromLocal(Pose2 p) {a.rot(p.a);return super.fromLocal(p);}


    @Override public String toString() {return super.toString()+"\ta: "+a+"\tangle: "+a.angle();}
}
