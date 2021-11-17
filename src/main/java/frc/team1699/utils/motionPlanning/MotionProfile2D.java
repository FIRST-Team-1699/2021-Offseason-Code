package team1699.utils;

import team1699.utils.motionPlanning.QuinticHermiteSplineGenerator;

public class MotionProfile2D{

    private final QuinticHermiteSplineGenerator path;
    private final double targetVelocity; //TODO Figure out units

    //TODO Figure out if we need a target acceleration
    public MotionProfile2D(QuinticHermiteSplineGenerator path, double targetVelocity){
        this.path = path;
        this.targetVelocity = targetVelocity;
    }

    public QuinticHermiteSplineGenerator getPath(){
        return path;
    }

    public double getTargetVelocity(){
        return targetVelocity;
    }
}
