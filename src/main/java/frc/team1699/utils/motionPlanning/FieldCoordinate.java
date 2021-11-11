package team1699.utils.motionPlanning;

public class FieldCoordinate {

    //Position on field in inches
    //0, 0 is located at the starting position of the robot?
    private final double x, y;

    public FieldCoordinate(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

}
