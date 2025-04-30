package utils.sorters.stringSorter.impl;

import utils.sorters.stringSorter.StringSorter;

import java.util.Collections;
import java.util.List;

public class StringSorterImpl implements StringSorter {
    @Override
    public void sortListCaseSensitive(List<String> list) {

    }

    @Override
    public void sortListCaseInsensitive(List<String> list) {
        shellSort(list);
    }

    private void shellSort(List<String> list) {
        for (int s = list.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < list.size(); ++i) {
                for (int j = i - s; j >= 0 && compareStrings(list.get(j), list.get(j + s)) > 0; j -= s) {
                    Collections.swap(list, j, j + s);
                }
            }
        }
    }

    private int compareStrings(String s1, String s2) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
        }
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}
