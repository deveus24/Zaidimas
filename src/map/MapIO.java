package map;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class MapIO
{
    public static void saveMap(char[][] map, String filePath) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for(char[] row : map)
        {
            for(int i = 0; i < row.length; i++)
            {
                writer.write(row[i]);
                if(i < row.length - 1) writer.write(',');
            }
            writer.newLine();
        }
        writer.close();
    }

    public static char[][] loadMap(String filePath) throws IOException
    {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
        }

        if (lines.isEmpty())
        {
            return new char[0][0];
        }

        int height = lines.size();
        int width = lines.get(0).split(",").length;
        char[][] map = new char[height][width];

        for (int y = 0; y < height; y++)
        {
            String[] parts = lines.get(y).split(",");
            for (int x = 0; x < width; x++) {
                map[y][x] = parts[x].charAt(0);
            }
        }
        return map;

    }
}

