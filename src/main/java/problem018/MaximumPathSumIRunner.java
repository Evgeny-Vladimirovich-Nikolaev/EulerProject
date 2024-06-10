package main.java.problem018;

import main.java.utils.numbresPyramidParser.impl.NumberPyramidParserImpl;
import main.java.problem018.numbersPyramid.NumbersPyramid;
import main.java.utils.numbresPyramidParser.NumberPyramidParser;
import main.java.utils.resourceReader.ResourceReader;
import main.java.utils.resourceReader.impl.ResourcesReaderImpl;

import java.util.List;

public class MaximumPathSumIRunner {

    public static void main(String[] args) {
        ResourceReader reader = new ResourcesReaderImpl();
        List<String> list = reader.readByLines("/docks/numbersPyramid.txt");
        for(String s : list) {
            System.out.println(s);
        }
        NumberPyramidParser parser = new NumberPyramidParserImpl();
        NumbersPyramid pyramid = parser.parse(list);
        long start = System.currentTimeMillis();
        int res = pyramid.calculateMaxPath();
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - start);
    }

}
