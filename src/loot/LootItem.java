package loot;

public class LootItem
{
    private String name;
    private String type;
    private int value;

    public LootItem(String name, String type, int value)
    {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getValue()
    {
        return value;
    }

    public void printInfo()
    {
        System.out.println(name + " (" + type + ") - Value: " + value);
    }
}
