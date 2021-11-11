package team1699.utils.motionPlanning;

//TODO Change to RobotPositionEstimator
public class RobotStateTracker {

    private final RobotState currentState;
    private double pastPortEncoder, pastStarEncoder;
    private Pos prevPos;
    private final double L;

    //Robot width in inches
    public RobotStateTracker(final double robotWidth){
        this.currentState = new RobotState();
        this.L = robotWidth / 2;
    }

    public void updateRobotState(double portEncoder, double starEncoder, double elapsedTime){
        double deltaPortEncoder = portEncoder - pastPortEncoder;
        double deltaStarEncoder = starEncoder - pastStarEncoder;

        Pos deltaPos = computePosChange(deltaPortEncoder, deltaStarEncoder);
        //TODO Sum positions and update robot state 
    }

    public Pos computePosChange(double deltaPortEncoder, double deltaStarEncoder){
        double deltaX = ((deltaPortEncoder + deltaStarEncoder) / 2) * Math.cos(prevPos.getTheta() + ((deltaStarEncoder - deltaPortEncoder) / 4 * L));
        double deltaY = ((deltaPortEncoder + deltaStarEncoder) / 2) * Math.sin(prevPos.getTheta() + ((deltaStarEncoder - deltaPortEncoder) / 4 * L));
        double deltaTheta = (deltaStarEncoder - deltaPortEncoder) / (2 * L);

        return new Pos(deltaX, deltaY, deltaTheta);
   }

    public static class Pos {
        private final double x, y, theta;

        public Pos(final double x, final double y, final double theta) {
            this.x = x;
            this.y = y;
            this.theta = theta;
        }

        public double getX(){
            return x;
        }

        public double getY(){
            return y;
        }

        public double getTheta(){
            return theta;
        }
    }

}
