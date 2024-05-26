package problem011;

import problem011.gridLargestProductFinder.gridLargestProductFinderImpl.GridLargestProductFinderImpl;
import problem011.gridParser.impl.GridParserImpl;
import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import java.util.List;

public class GridLargestProduct {

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        List<String> list = resourceReader.readByLines("/docks/p011_grid.txt");
        int[][] grid = new GridParserImpl().parse(list);
        GridLargestProductFinderImpl d = new GridLargestProductFinderImpl(grid, 4);

        long start = System.currentTimeMillis();

        int max = 0;
        for (int i = 0; i < 10_000; i++) {
            max = d.findLargestProduct();
        }
        long end = System.currentTimeMillis();

        System.out.println(max);
        System.out.println(end - start);
        System.out.println(max == 70600674);

    }
}
