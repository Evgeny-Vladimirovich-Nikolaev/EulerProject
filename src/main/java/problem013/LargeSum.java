package problem013;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import java.math.BigInteger;
import java.util.List;

public class LargeSum {

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        List<String> lines = resourceReader.readByLines("/docks/p013_large_sum.txt");
        System.out.println(calculateSum(lines));
    }

    private static BigInteger calculateSum(List<String> lines) {
        BigInteger sum = new BigInteger(lines.get(0));
        for(int ind = 1; ind < lines.size(); ind++) {
            sum = sum.add(new BigInteger(lines.get(ind)));
        }
        return sum;
    }

}
