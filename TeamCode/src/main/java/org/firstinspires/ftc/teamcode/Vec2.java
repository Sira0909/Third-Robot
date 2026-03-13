package org.firstinspires.ftc.teamcode;

public class Vec2 {
    public static final Vec2 ZERO=new Vec2();
    public double x=0,y=0;
    public Vec2   () {}
    public Vec2   (double X, double Y) {x=X;y=Y;}
    public Vec2   (Vec2 v) {this(v.x,v.y);}
    public Vec2   (double angle) {this(Math.cos(angle),Math.sin(angle));}
    public Vec2   set(double X, double Y) {x=X;y=Y;return this;}
    public Vec2   set(Vec2 v) {return set(v.x, v.y);}
    public Vec2   set(double angle){set(Math.cos(angle),Math.sin(angle)); return this;}
    public Vec2   copy() {return new Vec2(x,y);}
    public Vec2   add (Vec2 v) {x+=v.x;y+=v.y;return this;}
    public Vec2   add (double X, double Y) {x+=X;y+=Y;return this;}
    public Vec2   add (double v) {x+=v;y+=v;return this;}
    public Vec2   subt (Vec2 v) {x-=v.x;y-=v.y;return this;}
    public Vec2   subt (double X, double Y) {x-=X;y-=Y;return this;}
    public Vec2   subt (double v) {x-=v;y-=v;return this;}
    public Vec2   mult (Vec2 v) {x*=v.x;y*=v.y;return this;}
    public Vec2   mult (double X, double Y) {x*=X;y*=Y;return this;}
    public Vec2   mult (double v) {x*=v;y*=v;return this;}
    public Vec2   neg() {x=-x;y=-y;return this;}
    public Vec2   div (Vec2 v){x/=v.x;y/=v.y;return this;}
    public Vec2   div (double X, double Y) {x/=X;y/=Y;return this;}
    public Vec2   div (double v) {x/=v;y/=v;return this;}
    public double dot (Vec2 v) {return x*v.x+y*v.y;}
    /// dot of perpendicular v
    public double dotP (Vec2 v) {return y*v.x-x*v.y;}
    public double mag() {return Math.hypot(x,y);}
    public double magTo (Vec2 v) {return Math.hypot(x-v.x,y-v.y);}
    public Vec2   perp() {return set(-y, x);}
    public Vec2   norm() {double m = mag(); return (m==0.)?set(0.,0.):div(m);}
    public Vec2   norm(double v) {double m=mag();if(m!=0)m=v/m; return mult(m);}
    public Vec2   normTo(Vec2 v) {subt(v); double m = mag(); return (m==0.)?set(0.,0.):div(m);}
    public double angle() {return Math.atan2(y, x);}
    public double angleTo (Vec2 v) {return Math.atan2(v.y-y, v.x-x);}
    public Vec2   rot (Vec2 n) {return set(x*n.x-y*n.y,x*n.y+y*n.x);}
    public Vec2   rotN(Vec2 n) {return set(x*n.x+y*n.y,y*n.x-x*n.y);}
    public Vec2   rot (double X,double Y) {return set(x*X-y*Y,x*Y+y*X);}
    public Vec2   rotN(double X,double Y) {return set(x*X+y*Y,y*X-x*Y);}
    public Vec2   rot (double a) {return rot(new Vec2(a));}
    public Vec2   rotAround (double X,double Y,Vec2 n){return subt(X,Y).rot(n).add(X,Y);}
    public Vec2   rotAround (double X,double Y,double a){return subt(X,Y).rot(a).add(X,Y);}
    public Vec2   rotAround (Vec2 v,double a) {return subt(v).rot(a).add(v);}
    public Vec2   rotAround (Vec2 v, Vec2 n) {return subt(v).rot(n).add(v);}
    public Vec2   projectLine (Vec2 n) {double d=dot(n);return set(n).mult(d);}
    public Vec2   projectPlane (Vec2 n) {double d=dotP(n);return set(-n.y,n.x).mult(d);}
    public Vec2   reflectLine (Vec2 n) {Vec2 p=n.copy().perp();return subt(p.mult(dot(n)));}
    public Vec2   reflectPlane (Vec2 n) {return subt(n.copy().mult(2.*dot(n)));}
    public Vec2   toLocal(Vec2 v, double a){return subt(v).rot(-a);}
    public Vec2   toLocal(Vec2 v, Vec2 n){return subt(v).rotN(n);}
    public Vec2   fromLocal(Vec2 v, double a){return rot(a).add(v);}
    public Vec2   fromLocal(Vec2 v, Vec2 n){return rot(n).add(v);}
//    public Vec2   toLocal(Pose2 p){return toLocal(p, p.a);}
//    public Vec2   fromLocal(Pose2 p){return fromLocal(p,p.a);}
    public double tol(Vec2 v){return Math.max(Math.abs(x-v.x),Math.abs(y-v.y));}
    public boolean closeTol(Vec2 v){return Math.max(Math.abs(x-v.x),Math.abs(y-v.y))<1e-9;}
    public boolean equals(Vec2 v){return x==v.x&&y==v.y;}



    public String toString(){return "X: "+x+"\tY: "+y;}
}
