package main.java.problem028;

public class NumberSpiralDiagonals {

    private static final int COUNT = 1001;
    private static final int START = 1;

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix(COUNT,START);
        int[][] array = spiralMatrix.getMatrix();

//        MatrixPresentation matrixPresentation = new MatrixPresentation(array);
//        matrixPresentation.matrixToString();

        System.out.println(spiralMatrix.calculateDiagonalFromLeft());
        System.out.println(spiralMatrix.calculateDiagonalFromRight());
        System.out.println(spiralMatrix.calculateDiagonals());


    }

}
