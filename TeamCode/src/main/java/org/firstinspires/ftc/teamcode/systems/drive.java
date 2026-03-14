package org.firstinspires.ftc.teamcode.systems;

import org.firstinspires.ftc.teamcode.Vec2;

public class drive{
    private drive() {throw new RuntimeException("Stub!");}

    public static final wheels wheels=new wheels(/*put hardware map here*/);


    public void local(Vec2 v, double t){wheels.setForce(v,t);}
    public void local(Vec2 v, double t,double a){wheels.setForce(v,t,a);}
    public void local(double angle,double force, double t){wheels.setForceAng(angle,force,t);}
    public void local(double angle,double force, double t,double a){wheels.setForceAng(angle,force,t,a);}

    public void feild(Vec2 v, double t){wheels.setForce(new Vec2(v).rotN(RPose.norm),t);}
    public void feild(Vec2 v, double t,double a){wheels.setForce(new Vec2(v).rotN(RPose.norm),t,a);}
    public void feild(double angle,double force, double t){wheels.setForceAng(angle-RPose.angle,force,t);}
    public void feild(double angle,double force, double t,double a){wheels.setForceAng(angle-RPose.angle,force,t,a);}


}
