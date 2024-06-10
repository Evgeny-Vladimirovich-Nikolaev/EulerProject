package main.java.problem011;

import main.java.problem011.gridLargestProductFinder.gridLargestProductFinderImpl.GridLargestProductFinderImpl;
import main.java.problem011.gridParser.impl.GridParserImpl;
import main.java.utils.resourceReader.ResourceReader;
import main.java.utils.resourceReader.impl.ResourcesReaderImpl;

import java.util.Arrays;
import java.util.List;

public class GridLargestProduct {

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        List<String> list = resourceReader.readByLines("/docks/p011_grid.txt");
        int[][] grid = new GridParserImpl().parse(list);
        GridLargestProductFinderImpl productFinder = new GridLargestProductFinderImpl(grid, 4);

        long start = System.currentTimeMillis();

        int max = 0;
        for (int i = 0; i < 10_000; i++) {
            max = productFinder.findLargestProduct();
        }
        long end = System.currentTimeMillis();

        System.out.println(max);
        System.out.println(end - start);
        System.out.println(max == 70600674);

    }
}
