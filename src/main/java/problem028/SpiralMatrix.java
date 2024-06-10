package main.java.problem028;

public class SpiralMatrix {

    private static final int RIGHT = 0;
//    private static final int DOWN = 1;
//    private static final int LEFT = 2;
//    private static final int UP = 3;

    private static final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


//    private int[][] currentCell;

    private final int count;
    private final int start;
    private final int[][] matrix;
    private int row;
    private int column;

    public SpiralMatrix(int count, int start) {
        this.count = count;
        this.start = start;
        this.matrix = new int[count][count];
        fillMatrix();
    }

    private void fillMatrix() {
        row = column = findCenter();
        writeSpiral();
    }

    private int findCenter() {
        if(count % 2 == 1) {
            return count / 2;
        }
        return count / 2 - 1;
    }

    private void writeSpiral() {
        final int step = 2;
        int dir = RIGHT;
        int num = start;
        int path = 1;
        while (true) {
            for (int i = 0; i < step; i++) {
                for (int j = 0; j < path; j++) {
                    if (row < 0 || row >= count || column < 0 || column >= count) {
                        return;
                    }
                    matrix[row][column] = num++;
                    dir %= 4;
                    move(dir);
                }
                dir++;
            }
            path++;
        }
    }

    private void move(int dir) {
        row += directions[dir][1];
        column += directions[dir][0];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int calculateDiagonalFromLeft() {
        int sum = 0;
        for(int i = 0; i < count; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int calculateDiagonalFromRight() {
        int sum = 0;
        for(int i = 0, j = count - 1; i < count; i ++, j--) {
            sum += matrix[i][j];
        }
        return sum;
    }

    public int calculateDiagonals() {
        int sum = 0;
        for(int i = 0, j = count - 1; i < count; i++, j--) {
            sum += matrix[i][i];
            if(i != j) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
