package team1699.utils;

import static org.junit.Assert.*;
import org.junit.*; //TODO Remove * import
import team1699.utils.motionPlanning.QuinticHermiteSplineGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SplineGeneratorTest{

    private QuinticHermiteSplineGenerator qSplineGenerator = new QuinticHermiteSplineGenerator(0, 90, 0, 1, 2, 0, -0.1, -10, -10, -10);

    @Before
    public void setupTests(){

    }

    @Test
    public void testSimpleSplineGeneration(){
        qSplineGenerator.computeConstants();

        //Setup CSV output
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File("dump.csv"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return; //Something broke
        }
        pw.write("t, xpos, ypos\n");
        for(double i = 0; i <= 1; i = i + 0.001){
            pw.write(qSplineGenerator.genCSVString(i));
            pw.flush();
        }

        pw.close();
    }
}
