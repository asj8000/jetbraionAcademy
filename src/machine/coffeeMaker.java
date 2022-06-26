package machine;

import java.util.Objects;
import java.util.Scanner;

public class coffeeMaker {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public void makeCoffee() {
        if (storedResourceManagement.getStorageStatus("cups") == 0) {
            System.out.println("sorry. I can't make it. don't have enough cups.");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        if (Objects.equals(coffeeType, "back")) {
            return;
        }

        getCoffeeRequiredResource requiredResource = new getCoffeeRequiredResource(coffeeType);

        if (!checkStoredResource(requiredResource)) {
            outputCheckMessage(requiredResource);
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        storedResourceManagement.updateStoredResource(-requiredResource.water, -requiredResource.milk, -requiredResource.bean, -1, requiredResource.money);
    }

    public boolean checkStoredResource(getCoffeeRequiredResource requiredResource) {
        return storedResourceManagement.getStorageStatus("water") >= requiredResource.water &&
                storedResourceManagement.getStorageStatus("milk") >= requiredResource.milk &&
                storedResourceManagement.getStorageStatus("beans") >= requiredResource.bean;
    }

    public void outputCheckMessage(getCoffeeRequiredResource requiredResource) {
        if (storedResourceManagement.getStorageStatus("water") <= requiredResource.water) {
            System.out.println("Sorry, not enough water!");
        } else if (storedResourceManagement.getStorageStatus("milk") <= requiredResource.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (storedResourceManagement.getStorageStatus("beans") <= requiredResource.bean) {
            System.out.println("Sorry, not enough beans!");
        }
    }
}


class getCoffeeRequiredResource {
    int water = 0;
    int milk = 0;
    int bean = 0;
    int money = 0;

    public getCoffeeRequiredResource(String CoffeeType) {
        switch (CoffeeType) {
            case "1": //espresso
                this.water = 250;
                this.milk = 0;
                this.bean = 16;
                this.money = 4;
                break;
            case "2": //latte
                this.water = 350;
                this.milk = 75;
                this.bean = 20;
                this.money = 7;
                break;
            case "3": //cappuccino
                this.water = 200;
                this.milk = 100;
                this.bean = 12;
                this.money = 6;
                break;
        }
    }
}