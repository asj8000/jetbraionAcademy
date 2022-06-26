package coffeeMachine;
import java.util.Scanner;  // Import the Scanner class

public class CoffeeMachine04BuyFillTake {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    static Integer storedWater = 400;
    static Integer storedMilk = 540;
    static Integer storedBeans = 120;
    static Integer storedCups = 9;
    static Integer storedMoney = 550;

    public static void main(String[] args) {
        outputStorageStatus();
        String actionValue = getUserAction();
        switch (actionValue) {
            case "buy":
                makeCoffee();
                break;
            case "fill":
                fillResource();
                break;
            case "take":
                takeMoney();
                break;
        }
        outputStorageStatus();
    }

    public static void outputStorageStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(storedWater + " ml of water");
        System.out.println(storedMilk + " ml of milk");
        System.out.println(storedBeans + " g of coffee beans");
        System.out.println(storedCups + " disposable cups");
        System.out.println("$" + storedMoney + " of money");
    }

    public static String getUserAction() {
        System.out.println("Write action (buy, fill, take): ");
        return scanner.nextLine();
    }

    public static void makeCoffee() {
        if (storedCups == 0) {
            System.out.println("sorry. I can't make it. don't have enough cups.");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String coffeeType = scanner.nextLine();
        switch (coffeeType) {
            case "1":
                if (storedWater >= 250 && storedBeans >= 16) {
                    storedWater -= 250;
                    storedBeans -= 16;
                    storedCups -= 1;
                    storedMoney += 4;
                } else {
                    System.out.println("sorry. I can't make it. don't have enough rss.");
                }
                break;
            case "2":
                if (storedWater >= 350 && storedMilk >= 75 && storedBeans >= 20) {
                    storedWater -= 350;
                    storedMilk -= 75;
                    storedBeans -= 20;
                    storedCups -= 1;
                    storedMoney += 7;
                } else {
                    System.out.println("sorry. I can't make it. don't have enough rss.");
                }
                break;
            case "3":
                if (storedWater >= 200 && storedMilk >= 100 && storedBeans >= 12) {
                    storedWater -= 200;
                    storedMilk = storedMilk - 100;
                    storedBeans -= 12;
                    storedCups -= 1;
                    storedMoney += 6;
                } else {
                    System.out.println("sorry. I can't make it. don't have enough rss.");
                }
                break;
            default:
                break;
        }
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

        storedWater += addWater;
        storedMilk += addMilk;
        storedBeans += addBeans;
        storedCups += addCups;
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + storedMoney);
        storedMoney = 0;
    }

}

