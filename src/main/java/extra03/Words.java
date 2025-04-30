package extra03;

import utils.resourceReader.ResourceReader;
import utils.resourceReader.impl.ResourcesReaderImpl;

;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Words {

    private static List<String> russianWords;

    public static void main(String[] args) throws IOException {
        ResourceReader resourceReader = new ResourcesReaderImpl();
        russianWords = resourceReader.readByLines("/docks/words.txt", StandardCharsets.UTF_8);
        System.out.println(russianWords);
    }
}
