package problem81;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import java.util.ArrayList;
import java.util.List;

public class Problem81 {

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
//        List<String> list = resourceReader.readByLines("/docks/p081_matrix.txt");
//        List<List<Integer>> matrix = parseList(list);
//        int[][] array = matrixToArray(matrix);
//        if(isSquare(matrix)); {
//            TwoWaysPathSum twoWaysPathSum = new TwoWaysPathSum(array);
//            TwoWaysPathSum twoWaysPathSum = new TwoWaysPathSum(new int[][]
//                            {{131, 673, 234, 103, 18},
//                            {201, 96, 342, 965, 150},
//                            {630, 803, 746, 422, 111},
//                            {537, 699, 497, 121, 956},
//                            {805, 732, 524, 37, 331}});
            long start = System.currentTimeMillis();
            int[][] arr= getRandomArray(19);
            long end = System.currentTimeMillis();
            System.out.println(end - start);

            start = System.currentTimeMillis();
            TwoWaysPathSum twoWaysPathSum = new TwoWaysPathSum(arr);
            end = System.currentTimeMillis();
            System.out.println(twoWaysPathSum.getMinPathSum());
            System.out.println(end - start);
        }


    private static int[][] getRandomArray(int d){
        int[][] arr = new int[d][d];
        for(int row = 0; row < d; row++) {
            for(int col = 0; col < d; col++){
                arr[row][col] =(int) (Math.random() * 10_000);
            }
        }
        return arr;
    }

    private static List<List<Integer>> parseList(List<String> list) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (String s : list) {
            List<Integer> row = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int ind = 0; ind < s.length(); ind++) {
                char ch = s.charAt(ind);
                if(ch > 47 && ch < 58) {
                    sb.append(ch);
                } else {
                    row.add(Integer.valueOf(sb.toString()));
                    sb = new StringBuilder();
                }
            }
            row.add(Integer.valueOf(sb.toString()));
            matrix.add(row);
        }
        return matrix;
    }

    private static boolean isSquare(List<List<Integer>> matrix) {
        final int rows = matrix.size();
        for (List<Integer> list : matrix) {
            if(list.size() != rows) {
                return false;
            }
        }
        return true;
    }

    private static int[][] matrixToArray(List<List<Integer>> matrix) {
        int[][] array = new int[matrix.size()][matrix.size()];
        for(int row = 0; row < matrix.size(); row++) {
            for(int col = 0; col < matrix.size(); col++) {
                array[row][col] = matrix.get(row).get(col);
            }
        }
        return array;
    }

}
