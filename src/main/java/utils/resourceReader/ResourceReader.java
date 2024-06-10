package main.java.utils.resourceReader;

import java.util.List;

public interface ResourceReader {

    List<String> readByLines(String fileName);
    String readText(String fileName);
   void printConsole(String path);

}
