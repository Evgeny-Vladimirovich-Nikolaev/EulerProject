package extra03;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

import javax.print.DocFlavor;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Anagrams {

    private static String word;
    private static List<String> russianWords;
    private static List<Character> keys = new ArrayList<>();
    private static Map<Character, Integer> chars = new TreeMap<>();
    private static List<String> foundedWords = new ArrayList<>();
    private static List<String> exactWords = new ArrayList<>();

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        russianWords = resourceReader.readByLines("/docks/words.txt", StandardCharsets.UTF_8);
        for (String russianWord :
             russianWords) {
            word = russianWord;
            extracted();
        }
        System.out.println(exactWords);

    }

    private static void extracted() {
        int[] ch = word.chars().distinct().sorted().toArray();
        for (int i : ch) {
            keys.add((char) i);
        }
        for (int i : ch) {
            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == i) {
                    count++;
                }
            }
            chars.put((char) i, count);
        }
        List<String> temp = new ArrayList<>();
        for (String s : russianWords) {
            boolean accordance = true;
            for (int i = 0; i < s.length(); i++) {
                if (!keys.contains(s.charAt(i))) {
                    accordance = false;
                    break;
                }
            }
            if (accordance) {
                temp.add(s);
            }
        }
        for(String tmp : temp) {
            boolean accordance = true;
            for(char c : keys) {
                int count = 0;
                for(int i = 0; i < tmp.length(); i++){
                    if(tmp.charAt(i) == c) {
                        count++;
                        if(count > chars.get(c)) {
                            accordance = false;
                            break;
                        }
                    }
                }
            }
            if(accordance) {
                foundedWords.add(tmp);
            }

        }
        System.out.println(foundedWords);
        for(String s : foundedWords) {
            if(s.length() == word.length() && s.length() > 7) {
                exactWords.add(s);
            }
        }
    }
}
