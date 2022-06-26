package machine;

import java.util.Scanner;

public class coffeeMachine {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        boolean machinePowerStatus = true;
        coffeeMaker coffeeMaker = new coffeeMaker();
        while (machinePowerStatus) {
            String actionValue = getUserAction();
            outputEmptyLine();
            switch (actionValue) {
                case "buy":
                    coffeeMaker.makeCoffee();
                    break;
                case "fill":
                    fillResource();
                    break;
                case "take":
                    storedResourceManagement.takeMoney();
                    break;
                case "remaining":
                    storedResourceManagement.printStorageStatus();
                    break;
                case "exit":
                    machinePowerStatus = false;
                    break;
            }
            outputEmptyLine();
        }
    }

    public static String getUserAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.nextLine();
    }

    public static void fillResource() {
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCups = scanner.nextInt();

        storedResourceManagement.updateStoredResource(addWater, addMilk, addBeans, addCups, 0);
    }

    public static void outputEmptyLine() {
        System.out.println(" ");
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


class storedResourceManagement {
    public static Integer water = 400;
    public static Integer milk = 540;
    public static Integer beans = 120;
    public static Integer cups = 9;
    public static Integer money = 550;

    public storedResourceManagement() {
    }

    public static int getStorageStatus(String Type) {
        switch (Type) {
            case "water":
                return water;
            case "milk":
                return milk;
            case "beans":
                return beans;
            case "cups":
                return cups;
            case "money":
                return money;
            default:
                return 0;
        }
    }

    public static void printStorageStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(storedResourceManagement.water + " ml of water");
        System.out.println(storedResourceManagement.milk + " ml of milk");
        System.out.println(storedResourceManagement.beans + " g of coffee beans");
        System.out.println(storedResourceManagement.cups + " disposable cups");
        System.out.println("$" + storedResourceManagement.money + " of money");
    }

    public static void updateStoredResource(int water, int milk, int beans, int cups, int money) {
        storedResourceManagement.water += water;
        storedResourceManagement.milk += milk;
        storedResourceManagement.beans += beans;
        storedResourceManagement.cups += cups;
        storedResourceManagement.money += money;
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + storedResourceManagement.money);
        storedResourceManagement.money = 0;
    }

}

