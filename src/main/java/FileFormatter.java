import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileFormatter {
    private ArrayList<String> fileLines;

    public FileFormatter(String pathToEntryFile) throws IOException {
        this.fileLines = fileToStringArrayListByLines(pathToEntryFile);
    }

    public static ArrayList<String> fileToStringArrayListByLines(String filePath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader fileReader;

        fileReader = new BufferedReader(new FileReader(filePath));
        String line = fileReader.readLine();
        while (line != null){
            if(!isCommentary(line)){
                lines.add(line);
            }
            line = fileReader.readLine();
        }
        fileReader.close();

        return lines;
    }

    public ArrayList<String> getLinesOfFile() {
        return fileLines;
    }

    public static boolean isCommentary(String line){
        return line.startsWith("#");
    }

    public static boolean validateMap(String mapDimensions){
        return mapDimensions.matches("^C( - \\d){2}$");
    }

    public static boolean validateMoutain(String mountainPosition){
        return mountainPosition.matches("^M( - \\d){2}$");
    }

    public static boolean validateTreasure(String treasurePositionAndQuantity){
        return treasurePositionAndQuantity.matches("^T( - \\d){3}$");
    }

    public static boolean validateHero(String heroDetails){
        return heroDetails.matches("^A - [A-Za-z]+( - \\d){2} - [NSEO] - (A|D|G|)*$");
    }
}
