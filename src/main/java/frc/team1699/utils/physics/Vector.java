package team1699.utils.physics;

public class Vector{

    private final double magnitude, direction;

    //Direction is in radians
    public Vector(final double magnitude, final double direction){
        this.magnitude = magnitude;
        this.direction = direction;
    }

    public double getMagnitude(){
        return this.magnitude;
    }

    public double getDirection(){
        return this.direction;
    }
}
