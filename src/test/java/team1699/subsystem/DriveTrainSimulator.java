package team1699.subsystem;

public class DriveTrainSimulator{

    //Wheel Diameter Units: Inches
    //TODO Add other units
    private final double kWheelDiameter, kGRat, kRInertia, kV, kT, kR, kWheelBase;

    private double portEncoderDistance, starEncoderDistance, portCurrAngularVel, starCurrAngularVel, xPos, yPos, theta;

    public DriveTrainSimulator(final double kV, final double kT, final double kR){
        this.kV = kV;
        this.kT = kT;
        this.kR = kR;
        this.portCurrAngularVel = 0.0;
        this.starCurrAngularVel = 0.0;
        this.kWheelDiameter = 6.0;
        this.kGRat = 8.0;
        this.kRInertia = 0.1;
        this.kWheelBase = 30.0;
    }

    public double getPortAngularAcceleration(final double voltage){
        return (voltage - (portCurrAngularVel * kGRat) / kV) * (kT / (kRInertia * kR));
    }

    public double getStarAngularAcceleration(final double voltage){
        return (voltage - (starCurrAngularVel * kGRat) / kV) * (kT / (kRInertia * kR));
    }

    public void simTime(double dT, double portVoltage, double starVoltage){
        portCurrAngularVel += getPortAngularAcceleration(portVoltage) * dT;        
        starCurrAngularVel += getStarAngularAcceleration(starVoltage) * dT;        
        portEncoderDistance += angularToLinear(getPortCurrAngularVel()) * dT;
        starEncoderDistance += angularToLinear(getStarCurrAngularVel()) * dT;

        updatePosHeading(angularToLinear(getPortCurrAngularVel()) * dT, angularToLinear(getStarCurrAngularVel()) * dT);
    }

    private void updatePosHeading(double dPortEnc, double dStarEnc){
        final double L = kWheelBase / 2;

        double deltaX = ((dPortEnc + dStarEnc) / 2) * Math.cos(theta + ((dStarEnc - dPortEnc) / 4 * L));
        double deltaY = ((dPortEnc + dStarEnc) / 2) * Math.sin(theta + ((dStarEnc - dPortEnc) / 4 * L));
        double dTheta = (dStarEnc - dPortEnc) / (2 * L);

        xPos += deltaX;
        yPos += deltaY;
        theta += dTheta;
    }

    public double getXPos(){
        return xPos;
    }

    public double getYPos(){
        return yPos;
    }

    public double getTheta(){
        return theta;
    }

    public double getPortEncoderDistance(){
        return portEncoderDistance;
    }
    
    public double getStarEncoderDistance(){
        return starEncoderDistance;
    }

    public double getPortCurrAngularVel(){
        return portCurrAngularVel;
    }
    
    public double getStarCurrAngularVel(){
        return starCurrAngularVel;
    }

    public double angularToLinear(double angular){
        return angular * kWheelDiameter;
    }

    public double linearToAngular(double linear){
        return linear / kWheelDiameter;
    }
}
