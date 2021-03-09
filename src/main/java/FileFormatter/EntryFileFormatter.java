package FileFormatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class EntryFileFormatter {

    private EntryFileFormatter() {
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

    public static boolean isCommentary(String line){
        return line.startsWith("#");
    }

    public static boolean validateMap(String mapDimensions){
        return mapDimensions.matches("^C( - \\d){2}$");
    }

    public static boolean validateMountain(String mountainPosition){
        return mountainPosition.matches("^M( - \\d){2}$");
    }

    public static boolean validateTreasure(String treasurePositionAndQuantity){
        return treasurePositionAndQuantity.matches("^T( - \\d){3}$");
    }

    public static boolean validateHero(String heroDetails){
        return heroDetails.matches("^A - [A-Za-z]+( - \\d){2} - [NSEO] - (A|D|G|)*$");
    }

    public static boolean validateLine(String line){
        return validateMap(line) || validateMountain(line) || validateTreasure(line) || validateHero(line);
    }
}
