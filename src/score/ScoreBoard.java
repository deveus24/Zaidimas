package score;

import java.io.*;
import java.util.*;

public class ScoreBoard {
    private static final String FILE_PATH = "resources/scores.csv";

    public static void saveScore(ScoreEntry entry) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs(); // jei nėra resources katalogo, sukuria

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(entry.toCsv());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing score: " + e.getMessage());
        }
    }

    public static void printTopScores() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            int count = 1;
            System.out.println("Top Players:");
            while ((line = reader.readLine()) != null && count <= 100) {
                ScoreEntry entry = ScoreEntry.fromCsv(line);
                System.out.println(count + ". " + entry.getName() + " - Level: " + entry.getLevel() + " XP: " + entry.getXp());
                count++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No scores found.");
        }
    }
}
