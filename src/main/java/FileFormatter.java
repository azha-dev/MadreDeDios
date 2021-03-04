import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileFormatter {
    private ArrayList<String> linesOfFile;

    public FileFormatter(String pathToEntryFile) {
        this.linesOfFile = fileToStringArrayListByLines(pathToEntryFile);
    }

    public FileFormatter() { }

    public static ArrayList<String> fileToStringArrayListByLines(String filePath){
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader fileReader;

        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            String line = fileReader.readLine();
            while (line != null){
                lines.add(line);
                line = fileReader.readLine();
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
