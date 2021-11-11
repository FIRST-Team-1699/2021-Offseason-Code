package team1699.utils;

public class MatrixUtils{

    public static double[][] gaussJordonElimination(double[][] matrix){
         
        final int order = matrix.length;
        int swapCount;

        for(int i = 0; i < order; i++){
            //Check for swaps
            if(matrix[i][i] == 0){
                swapCount = 1;
                //Find how many rows need to be swapped
                while((i + swapCount) < order && matrix[i + swapCount][i] == 0){
                    swapCount++;
                }

                //Make sure we do not go out of bounds if nothing needs to be swapped
                if((i + swapCount) == order){
                    break;
                }

                //Make Swaps
                for(int k = 0; k <= order; k++){
                    double temp = matrix[i][k];
                    matrix[i][k] = matrix[i + swapCount][k];
                    matrix[i + swapCount][k] = temp;
                }
            }

            //Change matrix
            for(int j = 0; j < order; j++){
                if(i != j){
                    //Use to zero part of matrix
                    double temp = matrix[j][i] / matrix[i][i];

                    for(int k = 0; k <= order; k++){
                        matrix[j][k] = matrix[j][k] - (matrix[i][k]) * temp;
                    }
                }
            }
        }

        return matrix;
    }
}
