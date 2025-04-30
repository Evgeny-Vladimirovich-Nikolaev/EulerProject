package extra03;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PyramidWords {

    private static List<String> russianWords;
    private static List<String> pyramids = new ArrayList<>();

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        russianWords = resourceReader.readByLines("/docks/words.txt", StandardCharsets.UTF_8);
        long start = System.currentTimeMillis();
        findWordPyramids();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
        System.out.println(pyramids);
    }

    private static void findWordPyramids() {
        for (String source : russianWords) {
            StringBuilder changed = new StringBuilder(source);
            int count = 1;
            {
                for (int i = source.length(); i > 0; i--) {
                    changed.deleteCharAt(changed.length() - 1);
                    boolean isFind = false;
                    for (String comparing : russianWords) {
                        if (comparing.equalsIgnoreCase(changed.toString())) {
                            count++;
                            isFind = true;
                            break;
                        }
                    }
                    if (!isFind) {
                        break;
                    }
                }
            }
            if (count > 4) {
                System.out.println(source + "\t" + count);
                pyramids.add(source);
            }
        }
    }
}