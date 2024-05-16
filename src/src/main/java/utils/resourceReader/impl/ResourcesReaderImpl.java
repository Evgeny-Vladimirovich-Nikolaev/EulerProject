package utils.resourceReader.impl;

import utils.resourceReader.ResourceReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ResourcesReaderImpl implements ResourceReader {

    private InputStream getFileFromResourceAsStream(String fileName) {
        try {
            Class cls = ResourcesReaderImpl.class;
            InputStream inputStream = cls.getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("Файл " + fileName + " не найден");
            } else {
                return inputStream;
            }
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public List<String> readByLines(String fileName) {
        List<String> lines = new ArrayList<>();
        InputStream stream = getFileFromResourceAsStream(fileName);
        try (InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Не удалось прочитать файл ресурсов " + fileName);
            lines.add("нет данных");
        }
        return lines;
    }

    public String readText(String fileName) {
        StringBuilder sb = new StringBuilder();
        InputStream stream = getFileFromResourceAsStream(fileName);
        try (InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Не удалось прочитать файл ресурсов" + fileName);
        }
        return sb.toString();
    }

    public void printConsole(String path) {
        try (FileReader reader = new FileReader(path))
        {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}