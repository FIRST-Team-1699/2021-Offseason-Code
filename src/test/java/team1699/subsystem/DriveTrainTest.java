package team1699.subsystem;

import static org.junit.Assert.*;
import org.junit.*; //TODO Remove * import
import team1699.subsystem.DriveTrainSimulator;
import team1699.utils.MotorConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DriveTrainTest{

    private DriveTrainSimulator driveSim;

    @Before
    public void setupTest(){
        driveSim = new DriveTrainSimulator(MotorConstants.MotorDualFalcon.Kv, MotorConstants.MotorDualFalcon.Kt, MotorConstants.MotorDualFalcon.kResistance);
    }

    @Test
    public void testAccelerationCalculation(){
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File("driveDump.csv"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return; //Something Broke
        }
        pw.write("t, portAccel, starAccel, portVel, starVel, portDist, starDist, xPos, yPos, theta\n");

        final double dT = 0.01;
        for(double i = 0; i < 60; i = i + dT){
            double portVoltage = 12.0, starVoltage = 7.0;
            driveSim.simTime(dT, portVoltage, starVoltage);
            pw.write(String.format("%f,%f,%f,%f,%f,%f,%f,%f,%f,%f\n", i, driveSim.getPortAngularAcceleration(portVoltage), driveSim.getStarAngularAcceleration(starVoltage), driveSim.getPortCurrAngularVel(), driveSim.getStarCurrAngularVel(), driveSim.getPortEncoderDistance(), driveSim.getStarEncoderDistance(), driveSim.getXPos(), driveSim.getYPos(), driveSim.getTheta()));
            pw.flush();
        }

        pw.close();
    }

}
