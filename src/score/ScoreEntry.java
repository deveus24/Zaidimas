package score;

public class ScoreEntry {
    private String name;
    private int level;
    private int xp;

    public ScoreEntry(String name, int level, int xp) {
        this.name = name;
        this.level = level;
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public String toCsv() {
        return name + "," + level + "," + xp;
    }

    public static ScoreEntry fromCsv(String line) {
        String[] parts = line.split(",");
        return new ScoreEntry(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }
}
