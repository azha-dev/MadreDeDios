import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileFormatter {
    private ArrayList<String> linesOfFile;

    public FileFormatter(String pathToEntryFile) throws IOException {
        this.linesOfFile = fileToStringArrayListByLines(pathToEntryFile);
    }

    public static ArrayList<String> fileToStringArrayListByLines(String filePath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader fileReader;

        fileReader = new BufferedReader(new FileReader(filePath));
        String line = fileReader.readLine();
        while (line != null){
            lines.add(line);
            line = fileReader.readLine();
        }
        fileReader.close();

        return lines;
    }

    public ArrayList<String> getLinesOfFile() {
        return linesOfFile;
    }
}
