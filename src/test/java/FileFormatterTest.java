import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.io.TempDir;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FileFormatterTest {

    @TempDir
    static Path tempDir;

    @BeforeAll
    static void setup() {
        assertTrue(Files.isDirectory(tempDir));
    }

    @Test
    public void should_return_ArrayList_with_each_line_of_file_in_it() throws IOException {
        Path path = tempDir.resolve("testFile.txt");

        try {
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write(
                    "C - 3 - 4\n" +
                            "M - 1 - 1\n" +
                            "M - 2 - 2\n" +
                            "T - 0 - 3 - 2\n" +
                            "T - 1 - 3 - 1");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> expectedResult = new ArrayList<>() {{
            add("C - 3 - 4");
            add("M - 1 - 1");
            add("M - 2 - 2");
            add("T - 0 - 3 - 2");
            add("T - 1 - 3 - 1");
        }};
        assertEquals(expectedResult, FileFormatter.fileToStringArrayListByLines(path.toString()));
    }

    @Test
    public void should_throw_FileNotFoundException_if_file_doesnt_exist() {
        String fakePath = "/this/path/dont/work/file.txt";
        assertThrows(FileNotFoundException.class, () -> FileFormatter.fileToStringArrayListByLines(fakePath));
    }

    @Test
    public void should_initiate_linesOfFile_with_each_line_of_file_in_it() throws IOException {
        Path path = tempDir.resolve("testFile.txt");

        try {
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write(
                    "C - 3 - 4\n" +
                            "M - 1 - 1\n" +
                            "M - 2 - 2\n" +
                            "T - 0 - 3 - 2\n" +
                            "T - 1 - 3 - 1");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> expectedResult = new ArrayList<>() {{
            add("C - 3 - 4");
            add("M - 1 - 1");
            add("M - 2 - 2");
            add("T - 0 - 3 - 2");
            add("T - 1 - 3 - 1");
        }};
        FileFormatter fileFormatter = new FileFormatter(path.toString());
        assertEquals(expectedResult, fileFormatter.getLinesOfFile());
    }
}
