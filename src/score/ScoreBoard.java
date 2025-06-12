package score;

import java.io.*;
import java.util.*;

public class ScoreBoard
{
    private static final String FILE_PATH = "resources/scores.csv";

    public static void saveScore(ScoreEntry entry)
    {
        try
        {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(entry.toCsv());
            writer.newLine();
            writer.close();
        } catch (IOException e)
        {
            System.out.println("Error writing score: " + e.getMessage());
        }
    }

    public static void printTopScores()
    {
        try
        {
            File file = new File(FILE_PATH);
            if (!file.exists())
            {
                System.out.println("No scores found.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            List<ScoreEntry> entries = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null)
            {
                entries.add(ScoreEntry.fromCsv(line));
            }
            reader.close();


            entries.sort((a, b) ->
            {
                if (b.getLevel() != a.getLevel())
                {
                    return Integer.compare(b.getLevel(), a.getLevel());
                }
                else
                {
                    return Integer.compare(b.getXp(), a.getXp());
                }
            });


            System.out.println("=== Top Players ===");
            int count = 1;
            for (ScoreEntry entry : entries)
            {
                System.out.println(count + ". " + entry.getName() + " - Level: " + entry.getLevel() + " XP: " + entry.getXp());
                count++;
                if (count > 100) break;
            }

        } catch (IOException e)
        {
            System.out.println("Error reading scores: " + e.getMessage());
        }
    }
}

