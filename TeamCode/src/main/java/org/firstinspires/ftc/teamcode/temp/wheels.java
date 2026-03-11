package org.firstinspires.ftc.teamcode.temp;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class wheels{
    public double
    //f1 is front left force, -1 to 1
    f1=0,f2=0,
    f3=0,f4=0;

    public Motor
    m1,m2,
    m3,m4;


    public wheels(Motor fl,Motor fr,Motor bl,Motor br){
        m1=fl;m2=fr;m3=bl;m4=br;
    }
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

    public void updLastMotion(){
        m1.
    }
    public double
    motionX,
    motionY,
    motionT,


}
