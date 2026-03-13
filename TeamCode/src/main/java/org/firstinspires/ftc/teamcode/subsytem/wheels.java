package org.firstinspires.ftc.teamcode.subsytem;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Vec2;

public class wheels{
    public double
    //f1 is front left force, -1 to 1
    f1=0,f2=0,
    f3=0,f4=0;

    public Motor
    m1=new Motor(),m2=new Motor(),
    m3=new Motor(),m4=new Motor();


    public wheels(){

    }
    public void setForce(Vec2 v, double t){setForceVec(v.x,v.y,t);}
    public void setForce(Vec2 v, double t,double a){setForceVec(v.x,v.y,t,a);}
    public void setForce(double angle,double force, double t){setForceAng(angle,force,t);}
    public void setForce(double angle,double force, double t,double a){setForceAng(angle,force,t,a);}

    /// x is forwards y is sideways(left) t is rotation ↺, this works with trig and other math functions
    public void setForceVec(double x,double y, double t){
        double m =Math.abs(x)+Math.abs(y)+Math.abs(t);
        f1=x-y-t;
        f2=x+y-t;
        f3=x+y+t;
        f4=x-y+t;
        if(m<=1){
            update();
            return;
        }
        f1/=m;
        f2/=m;
        f3/=m;
        f4/=m;
        update();
    }
    public void setForceAng(double angle,double force, double t){
        setForceVec(Math.cos(angle)*force,Math.sin(angle)*force,t);
    }

    /// a=0 the robot won't slow down to turn, a=.5 moving and turning scaled down the same, a=1 the robot wont slow down its turning speed to move
    public void setForceVec(double x,double y, double t,double a){
        double move=Math.abs(x)+Math.abs(y);
        double turn=Math.abs(t);
        if(move+turn>1) {
            turn=(turn-(turn-1+move)*(1-a))/turn;
            move=(move-(move-1+Math.abs(t))*(a))/move;
        }else{move=1;turn=1;}
        f1=(x-y)*move-t*turn;
        f2=(x+y)*move-t*turn;
        f3=(x+y)*move+t*turn;
        f4=(x-y)*move+t*turn;
        update();
    }
    public void setForceAng(double angle,double force, double t,double a){
        setForceVec(Math.cos(angle)*force,Math.sin(angle)*force,t,a);
    }
    public void update(){
        m1.set(f1);
        m2.set(f2);
        m3.set(f3);
        m4.set(f4);
    }


    private double turnUnit=1;
    public double
    motionX=0,
    motionY=0,
    motionT=0;

    /// update motionX,Y,and T to the predicted forward, sideways and turn from the wheel motion since the last call to this function.
    /// @return the total distance wheels moved in a way that caused 0 motion, most likely sliding. use for uncertainty in the filter
    public double updMotion(){
        double w1=m1.getDistance();
        m1.resetEncoder();
        double w2=m2.getDistance();
        m2.resetEncoder();
        double w3=m3.getDistance();
        m3.resetEncoder();
        double w4=m4.getDistance();
        m4.resetEncoder();

        motionX=(w1+w2+w3+w4)/4;
        motionY=(-w1+w2+w3-w4)/4;
        motionT=turnUnit*(-w1+w2-w3+w4)/4;
        return (w1+w2-w3-w4);
    }

    /**
     set if using updMotion() to find where the wheel moved from the wheels motors encoders so motion is updated with the correct units
     @param c is circumference, distance the wheel travels per rotation
     @param d is distance the wheels are from the center
     @param units is units in 1 full rotation. for example use 360 for degrees
     */
    public void setupMotion(double c, double d, double units){
        m1.setDistancePerPulse(c/m1.getCPR());
        m2.setDistancePerPulse(c/m2.getCPR());
        m3.setDistancePerPulse(c/m3.getCPR());
        m4.setDistancePerPulse(c/m4.getCPR());

        turnUnit=units/(2*d*Math.PI);
    }





}
