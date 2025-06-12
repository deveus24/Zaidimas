package inventory;

import loot.LootItem;
import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    private List<LootItem> items;

    public Inventory()
    {
        items = new ArrayList<>();
    }

    public void addItem(LootItem item)
    {
        items.add(item);
    }

    public void printInventory()
    {
        if(items.isEmpty())
        {
            System.out.println("Inventory is empty");
        }
        else
        {
            System.out.println("Inventory:");
            for(LootItem item : items)
            {
                item.printInfo();
            }
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public LootItem removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

}
