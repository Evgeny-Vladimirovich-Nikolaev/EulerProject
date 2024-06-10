package main.java.problem011.gridLargestProductFinder.gridLargestProductFinderImpl;

import main.java.problem011.gridLargestProductFinder.GridLargestProductFinder;

public class GridLargestProductFinderImpl implements GridLargestProductFinder {

    private final int[][] grid;
    private final int sequenceLength;
    private int max = 0;

    public GridLargestProductFinderImpl(int[][] grid, int sequenceLength) {
        this.grid = grid;
        this.sequenceLength = sequenceLength;
    }

    @Override
    public int findLargestProduct() {
        calculateByRows();
        calculateByColumns();
        calculateByDiagonals();
        return max;
    }

    private void calculateByRows() {
        for (int[] row : grid) {
            int temp = maxInRow(row);
            if (temp > max) {
                max = temp;
            }
        }
    }

    private int maxInRow(int[] row) {
        int currentMax = 0;
        for (int ind = 0; ; ind++) {
            if (ind < row.length - sequenceLength + 1) {
                int temp = 1;
                for (int i = ind; i < ind + sequenceLength; i++) {
                    if (row[i] == 0) {
                        ind = i + 1;
                        break;
                    }
                    temp *= row[i];
                }
                if (temp > currentMax) {
                    currentMax = temp;
                }
            } else {
                break;
            }
        }
        return currentMax;
    }

    private void calculateByColumns() {
        for (int column = 0; column < grid[0].length; column++) {
            int temp = maxInColumn(column);
            if (temp > max) {
                max = temp;
            }
        }
    }

    private int maxInColumn(int column) {
        int currentMax = 0;
        for (int row = 0; ; row++) {
            if (row < grid.length - sequenceLength + 1) {
                int temp = 1;
                for (int ind = row; ind < row + sequenceLength; ind++) {
                    if (grid[ind][column] == 0) {
                        row = ind + 1;
                        break;
                    }
                    temp *= grid[ind][column];
                }
                if (temp > currentMax) {
                    currentMax = temp;
                }
            } else {
                break;
            }
        }
        return currentMax;
    }

    private void calculateByDiagonals() {
        for (int row = 0; row < grid.length - sequenceLength + 1; row++) {
            int temp = maxInDownDiagonal(row, true);
            if (temp > max) {
                max = temp;
            }
            temp = maxInDownDiagonal(row, false);
            if (temp > max) {
                max = temp;
            }
        }
    }

    private int maxInDownDiagonal(int row, boolean toRight) {
        int currentMax = 0;
        int multiply = 1;
        int column = 0;
        if(!toRight) {
            multiply = -1;
            column = sequenceLength - 1;
        }
        for(int count = 0; count <= grid[0].length - sequenceLength; count++, column++) {
            int temp = 1;
            for(int j = 0; j < sequenceLength; j++) {
                int val = grid[row + j][column + j * multiply];
                if(val == 0){
                    temp = 0;
                    break;
                }
                temp *= val;
            }
            if(temp > currentMax) {
                currentMax = temp;
            }
        }
        return currentMax;
    }

    private void calculateByRightDownDiagonal() {

    }

    private void calculateByLeftDownDiagonal() {

    }
}
