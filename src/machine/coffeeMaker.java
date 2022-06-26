package machine;

import java.util.Objects;
import java.util.Scanner;

public class coffeeMaker {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public void makeCoffee() {
        if (storedResource.getStorageStatus("cups") == 0) {
            System.out.println("sorry. I can't make it. don't have enough cups.");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        if (Objects.equals(coffeeType, "back")) {
            return;
        }
        CoffeeRequiredResource requiredResource;

        switch (coffeeType) {
            case "1": //espresso
                requiredResource = CoffeeRequiredResource.ESPRESSO;
                break;
            case "2": //latte
                requiredResource = CoffeeRequiredResource.LATTE;
                break;
            case "3": //cappuccino
                requiredResource = CoffeeRequiredResource.CAPPUCCINO;
                break;
            default:
                System.out.println("Wrong input");
                return;
        }

        if (!checkStoredResource(requiredResource)) {
            outputCheckMessage(requiredResource);
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        storedResource.updateStoredResource(-requiredResource.water, -requiredResource.milk, -requiredResource.bean, -1, requiredResource.money);
    }

    public boolean checkStoredResource(CoffeeRequiredResource requiredResource) {
        return storedResource.getStorageStatus("water") >= requiredResource.water &&
                storedResource.getStorageStatus("milk") >= requiredResource.milk &&
                storedResource.getStorageStatus("beans") >= requiredResource.bean;
    }

    public void outputCheckMessage(CoffeeRequiredResource requiredResource) {
        if (storedResource.getStorageStatus("water") <= requiredResource.water) {
            System.out.println("Sorry, not enough water!");
        } else if (storedResource.getStorageStatus("milk") <= requiredResource.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (storedResource.getStorageStatus("beans") <= requiredResource.bean) {
            System.out.println("Sorry, not enough beans!");
        }
    }
}

