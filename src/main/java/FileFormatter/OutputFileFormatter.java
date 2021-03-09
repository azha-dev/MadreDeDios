package FileFormatter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFileFormatter {

    public static void writeArrayListStringInFile(String outputFilePath, ArrayList<String> gameData) throws IOException {
        File outputFile = new File(outputFilePath);

        FileWriter fileWriter = new FileWriter(outputFile);
        for(String dataLine: gameData){
            fileWriter.write(dataLine + System.lineSeparator());
        }
        fileWriter.close();
    };
}
