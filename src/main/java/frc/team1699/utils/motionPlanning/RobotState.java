 package team1699.utils.motionPlanning;

 public class RobotState{

     private FieldCoordinate pos;
     private double vel, acc; //in m/s and m/s^2

     //Expected initial robot state
     public RobotState(){
         this.pos = new FieldCoordinate(0.0, 0.0);
         this.vel = 0.0;
         this.acc = 0.0;
     }

     public void updateState(FieldCoordinate pos, double vel, double acc){
         this.pos = pos;
         this.vel = vel;
         this.acc = acc;
     }

     public FieldCoordinate getPos(){
         return pos;
     }

     public double getVel(){
         return vel;
     }

     public double getAcc(){
         return acc;
     }
 }
