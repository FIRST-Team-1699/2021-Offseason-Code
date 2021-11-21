package team1699.utils;

import com.ctre.phoenix.motioncontrol.can.TalonFX;
import com.ctre.phoenix.motioncontrol.TalonFXControlMode;

public class SimTalonFX extends TalonFX{

    private final int deviceNumber;

    public SimTalonFX(final int deviceNumber){
        this.deviceNumber = deviceNumber;
    }

    @Override
    public void set(TalonFXControlMode mode, double value){

    }

    @Override
    public TalonFXSensorCollection getSensorCollection(){
        return null;
    }

    public double get(){
        return 0.0;
    }
}
