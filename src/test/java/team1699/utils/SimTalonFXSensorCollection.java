package team1699.utils;

import com.ctre.phoenix.motioncontrol.TalonFXSensorCollection;

public class SimTalonFXSensorCollection extends TalonFXSensorCollection{

    private final double sensorPos, absSensorPos, sensorVelocity;
    private final double fwdLimitSwitch, revLimitSwitch;

    public TalonFXSensorCollection(final double sensorPos, final double absSensorPos, final double sensorVelocity, final int fwdLimitSwitch, final int revLimitSwitch){
        this.sensorPos = sensorPos;
        this.absSensorPos = absSensorPos;
        this.sensorVelocity = sensorVelocity;
        this.fwdLimitSwitch = fwdLimitSwitch;
        this.revLimitSwitch = revLimitSwitch;
    }

    @Override
    public double getIntegratedSensorPosition(){
        return this.sensorPos;
    }

    @Override
    public double getIntegratedSensorAbolutePosition(){
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
