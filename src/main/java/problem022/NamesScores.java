package problem022;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;
import utils.sorters.stringSorter.StringSorter;
import utils.sorters.stringSorter.impl.StringSorterImpl;

import java.nio.charset.Charset;
import java.util.*;

public class NamesScores {

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        String namesString = resourceReader.readText("/docks/p022_names.txt", Charset.defaultCharset());
        String[] namesStrings = namesString.replace("\"", "").split(",");
        List<String> names = new ArrayList<>();
        for (String s : namesStrings) {
            names.add(s);
        }
        StringSorter stringSorter = new StringSorterImpl();
        stringSorter.sortListCaseInsensitive(names);
        System.out.println(namesScores(names));
    }

    private static int namesScores(List<String> names) {
        int scores = 0;
        int i = 0;
        while (i < names.size()) {
            String s = names.get(i);
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j);
            }
            sum -= s.length() * 64;
            sum *= ++i;
            scores += sum;
        }
        return scores;
    }

}
