package map;

import java.util.Random;

public class MapGenerator
{
    public static void main(String[] args) {
        MapGenerator gen = new MapGenerator();
        char[][] map = gen.generate(10, 5, 0.1, 0.05);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }

    public char[][] generate(int width, int height, double enemyProb, double lootProb)
    {
        char[][] map = new char[height][width];
        Random rand = new Random();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                double r = rand.nextDouble();
                if(r < enemyProb)
                {
                    map[y][x] = 'E';
                }
                else if(r < enemyProb + lootProb)
                {
                    map[y][x] = 'L';
                }
                else
                {
                    map[y][x] = '.';
                }
            }
        }
        int exitY = rand.nextInt(height);
        int exitX = rand.nextInt(width);
        map[exitY][exitX] = 'X';

        return map;
    }
}
