package team1699.subsystems;

public class DriveTrain implements Subsystem{

    private DriveState currentState;
    private DriveState wantedState;

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

    public enum DriveState {
        MANUAL,
        GOAL_TRACKING,
        AUTONOMOUS,
        MOTION_PROFILING
    }
}
