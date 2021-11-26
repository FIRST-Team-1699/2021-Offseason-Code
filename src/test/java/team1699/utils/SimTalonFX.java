package team1699.utils;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import team1699.utils.SimTalonFXSensorCollection;

public class SimTalonFX extends TalonFX{

    private final int deviceNumber;
    private double outputVoltage = 0.0;
    private final SimTalonFXSensorCollection simTalonFXSensorCollection;

    public SimTalonFX(final int deviceNumber, final SimTalonFXSensorCollection simTalonFXSensorCollection){
        super(deviceNumber);
        this.deviceNumber = deviceNumber;
        this.simTalonFXSensorCollection = simTalonFXSensorCollection;
    }

    @Override
    public void set(TalonFXControlMode mode, double value){
        //TODO Check that we are using voltage output
        this.outputVoltage = value;
    }

    @Override
    public TalonFXSensorCollection getSensorCollection(){
        return this.simTalonFXSensorCollection;
    }

    public double get(){
        return outputVoltage;
    }

}
