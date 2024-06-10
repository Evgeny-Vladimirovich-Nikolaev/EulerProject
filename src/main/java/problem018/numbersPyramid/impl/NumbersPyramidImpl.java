package main.java.problem018.numbersPyramid.impl;

import main.java.problem018.model.NumbersPyramidNode;
import main.java.problem018.numbersPyramid.NumbersPyramid;

public class NumbersPyramidImpl implements NumbersPyramid {

    private NumbersPyramidNode[][] pyramid;

    public NumbersPyramidImpl (NumbersPyramidNode[][] pyramid) {
        this.pyramid = pyramid;
    }

    public NumbersPyramidImpl (int[][] arr) {
        pyramid = new NumbersPyramidNode[arr.length][arr.length];
        for(int row = 0; row < arr.length; row++) {
            for (int ind = 0; ind < arr[row].length; ind++) {
                pyramid[row][ind] = new NumbersPyramidNode(arr[row][ind]);
            }
        }
    }

    @Override
    public int rows() {
        return pyramid.length;
    }

    @Override
    public int calculateMaxPath() {
        for(int row = pyramid.length - 2; row >= 0; row--) {
            for(int node = 0; node <= row; node++) {
                pyramid[row][node].calculatePathSum(
                        Integer.max(
                                pyramid[row + 1][node].getPathSum(),
                                pyramid[row + 1][node + 1].getPathSum()
                        )
                );
            }
        }
        return pyramid[0][0].getPathSum();
    }
}
