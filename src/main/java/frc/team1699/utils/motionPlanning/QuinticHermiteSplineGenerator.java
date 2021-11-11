package team1699.utils.motionPlanning;

import java.lang.Math;

public class QuinticHermiteSplineGenerator {

    private final double t0, t1, x0, y0, x1, y1, ax0, ay0, ax1, ay1;
    private double vx0, vy0, vx1, vy1, d;
     
    public QuinticHermiteSplineGenerator(double t0, double t1, double x0, double y0, double x1, double y1, double ax0, double ay0, double ax1, double ay1) {
        this.t0 = t0;
        this.t1 = t1;
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
        this.ax0 = ax0;
        this.ay0 = ay0;
        this.ax1 = ax1;
        this.ay1 = ay1;
    }

    public void computeConstants(){
        d = Math.sqrt(((x1 - x0) * (x1 - x0)) + ((y1 - y0) * (y1 - y0)));
        vx0 = Math.cos(t0 * (Math.PI / 180)) * d;
        vy0 = Math.sin(t0 * (Math.PI / 180)) * d;
        vx1 = Math.cos(t1 * (Math.PI / 180)) * d;
        vy1 = Math.sin(t1 * (Math.PI / 180)) * d;
    }

    //Quintic Hermite Base Functions (position, first derivative, second derivative)
    public double h0(double t){
        return -6*t*t*t*t*t + 15*t*t*t*t-10*t*t*t+1;
    }

    public double h1(double t){
        return -3*t*t*t*t*t+8*t*t*t*t-6*t*t*t+t;
    }

    public double h2(double t){
        return (-(t*t*t*t*t)/2)+((3*t*t*t*t)/2)-((3*t*t*t)/2)+((t*t)/2);
    }

    public double h3(double t){
        return ((t*t*t*t*t)/2)-t*t*t*t+((t*t*t)/2);
    }

    public double h4(double t){
        return -3*t*t*t*t*t+7*t*t*t*t-4*t*t*t;
    }

    public double h5(double t){
        return 6*t*t*t*t*t-15*t*t*t*t+10*t*t*t;
    }

    public double hd0(double t){
        return -30*t*t*t*t + 60*t*t*t-30*t*t;
    }

    public double hd1(double t){
        return -15*t*t*t*t+32*t*t*t-18*t*t+1;
    }

    public double hd2(double t){
        return (-(5*t*t*t*t)/2)+((6*t*t*t))-((9*t*t)/2)+t;
    }

    public double hd3(double t){
        return ((5*t*t*t*t)/2)-4*t*t*t+((3*t*t)/2);
    }

    public double hd4(double t){
        return -15*t*t*t*t+28*t*t*t-12*t*t;
    }

    public double hd5(double t){
        return 30*t*t*t*t-60*t*t*t+30*t*t;
    }
    
    public double hdd0(double t){
        return -120*t*t*t+180*t*t-60*t;
    }

    public double hdd1(double t){
        return -60*t*t*t+96*t*t-36*t;
    }

    public double hdd2(double t){
        return -10*t*t*t+((18*t*t))-(9*t)+1;
    }

    public double hdd3(double t){
        return t*(10*t*t-12*t+3);
    }

    public double hdd4(double t){
        return -60*t*t*t+84*t*t-24*t;
    }

    public double hdd5(double t){
        return 120*t*t*t-180*t*t+60*t;
    }

    public double hddd0(double t){
        return -360*t*t+360*t-60;
    }

    public double hddd1(double t){
        return -180*t*t+192*t-36;
    }

    public double hddd2(double t){
        return -30*t*t+36*t-9;
    }

    public double hddd3(double t){
        return 30*t*t-24*t+3;
    }

    public double hddd4(double t){
        return -180*t*t+168*t-24;
    }

    public double hddd5(double t){
        return 360*t*t-360*t+60;
    }

    public double xp(double t){
        return h0(t)*x0+h1(t)*vx0+h2(t)*ax0+h3(t)*ax1+h4(t)*vx1+h5(t)*x1;
    }
    
    public double yp(double t){
        return h0(t)*y0+h1(t)*vy0+h2(t)*ay0+h3(t)*ay1+h4(t)*vy1+h5(t)*y1;
    }

    public double xd(double t){
        return hd0(t)*x0+hd1(t)*vx0+hd2(t)*ax0+hd3(t)*ax1+hd4(t)*vx1+hd5(t)*x1;
    }
    
    public double yd(double t){
        return hd0(t)*y0+hd1(t)*vy0+hd2(t)*ay0+hd3(t)*ay1+hd4(t)*vy1+hd5(t)*y1;
    }

    public double xdd(double t){
        return hdd0(t)*x0+hdd1(t)*vx0+hdd2(t)*ax0+hdd3(t)*ax1+hdd4(t)*vx1+hdd5(t)*x1;
    }
    
    public double ydd(double t){
        return hdd0(t)*y0+hdd1(t)*vy0+hdd2(t)*ay0+hdd3(t)*ay1+hdd4(t)*vy1+hdd5(t)*y1;
    }

    public double xddd(double t){
        return hddd0(t)*x0+hddd1(t)*vx0+hddd2(t)*ax0+hddd3(t)*ax1+hddd4(t)*vx1+hddd5(t)*x1;
    }
    
    public double yddd(double t){
        return hddd0(t)*y0+hddd1(t)*vy0+hddd2(t)*ay0+hddd3(t)*ay1+hddd4(t)*vy1+hddd5(t)*y1;
    }

    public double curvature(double t){
        //TODO Add
        return 0.0;
    }

    //TODO compute e1 and e1
    
    public String genCSVString(double t){
        return String.format("%f,%f,%f\n", t, xp(t), yp(t));
    }
}
