import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.io.TempDir;


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
    public void should_not_include_commentary_line() throws IOException {
        Path path = tempDir.resolve("testFile.txt");

        try {
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write(
                    "C - 3 - 4\n" +
                            "# This is a beautiful commentary\n"+
                            "M - 1 - 1\n" +
                            "M - 2 - 2\n" +
                            "#Thiscommentaryisnotverybeautiful\n"+
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
    public void isCommentary_should_return_false_if_parameter_not_start_by_hashtag(){
        String importantString = "C - 3 -4";
        assertFalse(FileFormatter.isCommentary(importantString));
    }

    @Test
    public void isCommentary_should_return_true_if_parameter_start_by_hashtag(){
        String commentary = "#This is a beautiful commentary";
        assertTrue(FileFormatter.isCommentary(commentary));
    }

    @Test
    public void validateMap_should_return_true_if_string_match(){
        String matchingString = "C - 4 - 7";
        assertTrue(FileFormatter.validateMap(matchingString));
    }

    @Test
    public void validateMap_should_return_false_if_string_dont_match(){
        String notMatchingString = "This string isn't matching";
        assertFalse(FileFormatter.validateMap(notMatchingString));
    }

    @Test
    public void validateMountain_should_return_true_if_string_match(){
        String matchingString = "M - 4 - 7";
        assertTrue(FileFormatter.validateMountain(matchingString));
    }

    @Test
    public void validateMountain_should_return_false_if_string_dont_match(){
        String notMatchingString = "This string isn't matching";
        assertFalse(FileFormatter.validateMountain(notMatchingString));
    }

    @Test
    public void validateTreasure_should_return_true_if_string_match(){
        String matchingString = "T - 4 - 7 - 8";
        assertTrue(FileFormatter.validateTreasure(matchingString));
    }

    @Test
    public void validateTreasure_should_return_false_if_string_dont_match(){
        String notMatchingString = "This string isn't matching";
        assertFalse(FileFormatter.validateTreasure(notMatchingString));
    }

    @Test
    public void validateHero_should_return_true_if_string_match(){
        String matchingString = "A - Lara - 1 - 1 - S - AADADAGGA";
        assertTrue(FileFormatter.validateHero(matchingString));
    }

    @Test
    public void validateHero_should_return_false_if_string_dont_match(){
        String notMatchingString = "This string isn't matching";
        assertFalse(FileFormatter.validateHero(notMatchingString));
    }

    @Test
    public void validateLine_should_return_true_if_line_match_one_validator(){
        String matchingString = "A - Lara - 1 - 1 - S - AADADAGGA";
        assertTrue(FileFormatter.validateLine(matchingString));
    }

    @Test
    public void validateLine_should_return_false_if_line_not_match_any_of_validator(){
        String notMatchingString = "This string isn't matching";
        assertFalse(FileFormatter.validateLine(notMatchingString));
    }
}
