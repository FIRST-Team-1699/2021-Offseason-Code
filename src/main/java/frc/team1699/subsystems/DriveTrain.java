package team1699.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class DriveTrain implements Subsystem{

    private DriveState currentState;
    private DriveState wantedState;

    //TODO Need port motor group, star motor group, port encoder, star encoder
    private double currPortEncoderPos, currStarEncoderPos, robotXPos, robotStarPos, robotHeading;

    private final TalonFX portMaster, portSlave, starMaster, starSlave;

    public DriveTrain(final TalonFX portMaster, final TalonFX portSlave, final TalonFX starMaster, final TalonFX starSlave){
        this.currPortEncoderPos = 0.0;
        this.currStarEncoderPos = 0.0;
        this.robotXPos = 0.0;
        this.robotStarPos = 0.0;
        this.robotHeading = 0.0;

        this.portMaster = portMaster;
        this.portSlave = portSlave;
        this.starMaster = starMaster;
        this.starSlave = starSlave;

        this.wantedState = DriveState.MANUAL;
    }

    public void update(){
        switch(currentState){
            case MANUAL:
                break;
            case GOAL_TRACKING:
                break;
            case AUTONOMOUS:
                break;
            case MOTION_PROFILING:
                break;
            default:
                break;
        }        
    }

    private void arcadeDrive(double throttle, double rotate){
        double portOutput = 0.0;
        double starOutput = 0.0;

        throttle = Math.copySign(throttle * throttle, throttle);
        rotate = Math.copySign(rotate * rotate, rotate);

        double maxInput = Math.copySign(Math.max(Math.abs(throttle), Math.abs(rotate)), throttle);

        if(throttle >= 0.0){
            if(rotate >= 0.0){
                portOutput = maxInput;
                starOutput = throttle - rotate;
            }else{
                portOutput = throttle + rotate;
                starOutput = maxInput;
            }
        }else{
            if(rotate >= 0.0){
                portOutput = throttle + rotate;
                starOutput = maxInput;
            }else{
                portOutput = maxInput;
                starOutput = throttle - rotate;
            }
        }

        //TODO Output results
    }

    public void updateOdometry(){

    }

    public void followMotionProfile(){

    }

    public enum DriveState {
        MANUAL,
        GOAL_TRACKING,
        AUTONOMOUS,
        MOTION_PROFILING
    }
}
