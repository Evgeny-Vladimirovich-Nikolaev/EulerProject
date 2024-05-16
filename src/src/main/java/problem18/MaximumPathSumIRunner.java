package problem18;

import problem18.model.NumbersPyramidNode;
import problem18.numbersPyramid.NumbersPyramid;
import problem18.numbersPyramid.impl.NumbersPyramidImpl;
import utils.numbresPyramidParser.NumberPyramidParser;
import utils.numbresPyramidParser.impl.NumberPyramidParserImpl;
import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import java.util.Arrays;
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
