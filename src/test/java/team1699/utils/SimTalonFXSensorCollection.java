package team1699.utils;

import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;

public class SimTalonFXSensorCollection extends TalonFXSensorCollection{

    private double sensorPos, absSensorPos, sensorVelocity;
    private int fwdLimitSwitch, revLimitSwitch;

    public SimTalonFXSensorCollection(final double sensorPos, final double absSensorPos, final double sensorVelocity, final int fwdLimitSwitch, final int revLimitSwitch){
        super(null);
        this.sensorPos = sensorPos;
        this.absSensorPos = absSensorPos;
        this.sensorVelocity = sensorVelocity;
        this.fwdLimitSwitch = fwdLimitSwitch;
        this.revLimitSwitch = revLimitSwitch;
    }

    public void setSensorPos(final double sensorPos){
        this.sensorPos = sensorPos;
    }

    public void setAbsSensorPos(final double absSensorPos){
        this.absSensorPos = absSensorPos;
    }

    public void setSensorVelocity(final double sensorVelocity){
        this.sensorVelocity = sensorVelocity;
    }

    public void setFwdLimitSwitch(final int fwdLimitSwitch){
        this.fwdLimitSwitch = fwdLimitSwitch;
    }

    public void setRevLimitSwitch(final int revLimitSwitch){
        this.revLimitSwitch = revLimitSwitch;
    }

    @Override
    public double getIntegratedSensorPosition(){
        return this.sensorPos;
    }

    @Override
    public double getIntegratedSensorAbsolutePosition(){
        return this.absSensorPos;
    }

    @Override
    public double getIntegratedSensorVelocity(){
        return this.sensorVelocity;
    }

    @Override
    public int isFwdLimitSwitchClosed(){
        return this.fwdLimitSwitch;
    }

    @Override public int isRevLimitSwitchClosed(){
        return this.revLimitSwitch;
    }
}
