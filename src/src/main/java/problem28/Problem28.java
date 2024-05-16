package problem28;

import java.util.Arrays;

public class Problem28 {

    private static final int COUNT = 11;
    private static final int START = 1;

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix(COUNT,START);
        int[][] array = spiralMatrix.getMatrix();

        MatrixPresentation matrixPresentation = new MatrixPresentation(array);
        matrixPresentation.matrixToString();

        System.out.println(spiralMatrix.calculateDiagonalFromLeft());
        System.out.println(spiralMatrix.calculateDiagonalFromRight());
        System.out.println(spiralMatrix.calculateDiagonals());


    }

}
