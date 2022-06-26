package machine;

import java.util.Objects;
import java.util.Scanner;

public class coffeeMaker {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public void makeCoffee() {
        if (machine.storedResourceManagement.getStorageStatus("cups") == 0) {
            System.out.println("sorry. I can't make it. don't have enough cups.");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        if (Objects.equals(coffeeType, "back")) {
            return;
        }

        machine.getCoffeeRequiredResource requiredResource = new machine.getCoffeeRequiredResource(coffeeType);

        if (!checkStoredResource(requiredResource)) {
            outputCheckMessage(requiredResource);
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        machine.storedResourceManagement.updateStoredResource(-requiredResource.water, -requiredResource.milk, -requiredResource.bean, -1, requiredResource.money);
    }

    public boolean checkStoredResource(machine.getCoffeeRequiredResource requiredResource) {
        return machine.storedResourceManagement.getStorageStatus("water") >= requiredResource.water &&
                machine.storedResourceManagement.getStorageStatus("milk") >= requiredResource.milk &&
                machine.storedResourceManagement.getStorageStatus("beans") >= requiredResource.bean;
    }

    public void outputCheckMessage(machine.getCoffeeRequiredResource requiredResource) {
        if (machine.storedResourceManagement.getStorageStatus("water") <= requiredResource.water) {
            System.out.println("Sorry, not enough water!");
        } else if (machine.storedResourceManagement.getStorageStatus("milk") <= requiredResource.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (machine.storedResourceManagement.getStorageStatus("beans") <= requiredResource.bean) {
            System.out.println("Sorry, not enough beans!");
        }
    }
}
