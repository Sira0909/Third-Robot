package org.firstinspires.ftc.teamcode.systems;

//import static org.firstinspires.ftc.teamcode.utils.RPose;
import static org.firstinspires.ftc.teamcode.utils.robot;

import org.firstinspires.ftc.teamcode.Vec2;
public class Drive {
    public final wheels wheels=new wheels(
            robot.leftFront,
            robot.rightFront,
            robot.leftBack,
            robot.rightBack);

    public void local(Vec2 v, double t){wheels.setForce(v,t);}
    public void local(double x,double y, double t){wheels.setForceVec(x,y,t);}
    public void local(Vec2 v, double t,double a){wheels.setForce(v,t,a);}
    public void localDir(double angle,double force, double t){wheels.setForceAng(angle,force,t);}
    public void localDir(double angle,double force, double t,double a){wheels.setForceAng(angle,force,t,a);}

    //public void field(Vec2 v, double t){wheels.setForce(new Vec2(v).rotN(RPose.norm),t);}
    //public void field(Vec2 v, double t,double a){wheels.setForce(new Vec2(v).rotN(RPose.norm),t,a);}
    //public void field(double angle,double force, double t){wheels.setForceAng(angle-RPose.dir,force,t);}
    //public void field(double angle,double force, double t,double a){wheels.setForceAng(angle-RPose.dir,force,t,a);}
}
