package utils.numbresPyramidParser.impl;

import problem18.numbersPyramid.NumbersPyramid;
import problem18.numbersPyramid.impl.NumbersPyramidImpl;
import utils.numbresPyramidParser.NumberPyramidParser;

import java.util.Arrays;
import java.util.List;

public class NumberPyramidParserImpl implements NumberPyramidParser {

    @Override
    public NumbersPyramid parse(List<String> list) {
        int[][] numbers = parseIntArrayFromStrings(list);
        for(int[] arr : numbers) {
            System.out.println(Arrays.toString(arr));
        }
        NumbersPyramid pyramid = new NumbersPyramidImpl(numbers);
        return pyramid;
    }

    private int[][] parseIntArrayFromStrings(List<String> list) {
        int[][] numbers = new int[list.size()][list.size()];
        for (int line = 0; line < list.size(); line++) {
            String str = list.get(line);
            int strPos = 0;
            for (int ind = 0; ind <= line; ind++) {
                String substring = "";
                while (strPos < str.length()) {
                    char ch = str.charAt(strPos);
                    strPos++;
                    if (ch != 32) {
                        substring += ch;
                    } else {
                        break;
                    }
                }
                numbers[line][ind] = Integer.valueOf(substring);
            }
        }
        return numbers;
    }
}
