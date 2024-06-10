package main.java.problem081;

public class TwoWaysPathSum {

    private final int[][] matrix;
    private int minPathSum = Integer.MAX_VALUE;

    public TwoWaysPathSum(int[][] matrix) {
        this.matrix = matrix;
        calculateMinPathSum(0, 0, 0);
    }

    public int getMinPathSum() {
        return minPathSum;
    }

    private void calculateMinPathSum(int sum, int row, int column) {
        sum += matrix[row][column];
        if(row == matrix.length - 1 && column == matrix.length -1) {
            if(sum < minPathSum)
            minPathSum = sum;
            return;
        }
        if(row < matrix.length - 1) {
            calculateMinPathSum(sum, row + 1, column);
        }
        if(column < matrix.length - 1) {
            calculateMinPathSum(sum, row, ++column);
        }
    }
}
