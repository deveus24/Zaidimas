package store;

import loot.LootItem;
import inventory.Inventory;
import java.util.Scanner;

public class Store {

    public void enterStore(Inventory inventory) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Store!");
            System.out.println("1. Sell items");
            System.out.println("2. View inventory");
            System.out.println("0. Exit store");
            System.out.print("Choose option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    sellItems(inventory, scanner);
                    break;
                case "2":
                    inventory.printInventory();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void sellItems(Inventory inventory, Scanner scanner) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Nothing to sell.");
            return;
        }

        inventory.printInventory();
        System.out.println("Enter index of item to sell (starting from 1), or 0 to cancel:");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (choice == 0) {
            System.out.println("Sale cancelled.");
            return;
        }

        LootItem item = inventory.removeItem(choice - 1);
        if (item != null) {
            System.out.println("Sold " + item.getName() + " for " + item.getValue() + " gold!");
        } else {
            System.out.println("Invalid item index.");
        }
    }
}
