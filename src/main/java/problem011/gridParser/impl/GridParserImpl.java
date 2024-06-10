package main.java.problem011.gridParser.impl;

import main.java.problem011.gridParser.GridParser;

import java.util.List;

public class GridParserImpl implements GridParser {

    @Override
    public int[][] parse(List<String> list) {
        int columns, rows;
        int[][] grid;
        rows = list.size();
        columns = calculateColumns(list.get(0));
        grid = new int[columns][rows];
        fillGrid(grid, list);
        return grid;
    }

    private int calculateColumns(String row) {
        int columns = 1;
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == 32) {
                columns++;
            }
        }
        return columns;
    }

    private void fillGrid(int[][] grid, List<String> list) {
        for (int row = 0; row < grid.length; row++) {
            String s = list.get(row);
            int ind = 0;
            for (int column = 0; column < grid[0].length; column++) {
                StringBuilder num = new StringBuilder();
                while (ind < s.length() && s.charAt(ind) != 32) {
                    num.append(s.charAt(ind++));
                }
                grid[row][column] = Integer.valueOf(num.toString());
                ind++;
            }
        }
    }
}
