package utils.resourceReader;

import java.nio.charset.Charset;
import java.util.List;

public interface ResourceReader {

    List<String> readByLines(String fileName);

    List<String> readByLines(String fileName, Charset charset);
    String readText(String fileName);

    String readText(String fileName, Charset charset);
   void printConsole(String path);

}
