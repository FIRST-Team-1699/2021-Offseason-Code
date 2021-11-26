package team1699.utils.motionPlanning;

import team1699.utils.motionPlanning.QuinticHermiteSplineGenerator;
import java.util.List;
import java.util.ArrayList;
import team1699.utils.physics.Vector;

public class MotionProfile2D{
    public static final double kSamplePointSplitDistance = 3.0;
    public static final double kTimeStep = 0.01;

    private final QuinticHermiteSplineGenerator path;
    private final double kMaxForwardVelocity;
    private final double kMaxRotationalVelocity;

    private List<Point> samplePoints;
    private List<Vector> goalFowardVectors;
    private List<Vector> goalRoationalVectors;

    //TODO Add acceleration 
    public MotionProfile2D(final QuinticHermiteSplineGenerator path, final double kMaxForwardVelocity, final double kMaxRotationalVelocity){
        this.path = path;
        this.kMaxForwardVelocity = kMaxForwardVelocity;
        this.kMaxRotationalVelocity = kMaxRoationalVelocity;
        this.samplePoints = generateSampleTrajectory();
        this.goalFowardVectors = new ArrayList<>();
        this.goalRotationalVectors = new ArrayList<>();
    }

    //TODO Refactor return type to void
    public List<Point> generateSampleTrajectoryPoints(){
        List<Point> points = new ArrayList<>();
        double sumDist = 0;
        for(double i = kTimeStep; i < 1; i += kTimeStep){
            double dx = getDist(path.xp(i - kTimeStep), path.xp(i));
            double dy = getDist(path.yp(i - kTimeStep), path.yp(i));
            double dist = Math.sqrt((dx / kTimeStep) * (dx / kTimeStep) + (dy / kTimeStep) * (dy / kTimeStep));
            sumDist += dist;
            if(sumDist >= kSamplePointSplitDistance){
                points.add(new Point(path.xp(i), path.yp(i)));
                sumDist = 0;
            }
        }
        return points;
    }

    public void fowardPassSamplePoints(){
        for(int i = 0; i < samplePoints.size() - 1; i++){
            double xComponent = path.xd(i);
            double yComponent = path.yd(i);
            double nextXComponent = path.xd(i + 1);
            double nextYComponent = path.yd(i + 1);
            double magnituge = Math.sqrt((xComponent * xComponent) + (yComponent * yComponent));
            double direction = Math.atan(yComponent / xComponent);
            double nextDirection = Math.atan(nextYComponent + nextXComponent);
            goalForwardVectors.add(magnitude);
            goalRotaionalVectors.add((nextDirection - direction) / kTimeStep);
        }
    }
    

    private double getDist(double p1, double p2){
        return p2 - p1;
    }

    public QuinticHermiteSplineGenerator getPath(){
        return path;
    }

    public double getTargetVelocity(){
        return targetVelocity;
    }

    public List<Vector> getGoalFowardVectors(){
        return this.goalFowardVectors;
    }

    public List<Vector> getGoalRotaionalVectors(){
        return this.goalRoationalVectors;
    }

    public static class Point{

        public double x, y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
