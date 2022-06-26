package coffeeMachine;

import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class

public class CoffeeMachine05supplies {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    static Integer storedWater = 400;
    static Integer storedMilk = 540;
    static Integer storedBeans = 120;
    static Integer storedCups = 9;
    static Integer storedMoney = 550;

    public static void main(String[] args) {
        boolean machinePowerStatus = true;
        while (machinePowerStatus) {
            String actionValue = getUserAction();
            outputEmptyLine();
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
                case "remaining":
                    outputStorageStatus();
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

    public static void outputStorageStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(storedWater + " ml of water");
        System.out.println(storedMilk + " ml of milk");
        System.out.println(storedBeans + " g of coffee beans");
        System.out.println(storedCups + " disposable cups");
        System.out.println("$" + storedMoney + " of money");
    }


    public static void makeCoffee() {
        if (storedCups == 0) {
            System.out.println("sorry. I can't make it. don't have enough cups.");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        if (Objects.equals(coffeeType, "back")) {
            return;
        }

        int requiredWater = 0;
        int requiredMilk = 0;
        int requiredBeans = 0;
        int payAmount = 0;

        switch (coffeeType) {
            case "1":
                requiredWater = 250;
                requiredBeans = 16;
                payAmount = 4;
                break;
            case "2":
                requiredWater = 350;
                requiredMilk = 75;
                requiredBeans = 20;
                payAmount = 7;
                break;
            case "3":
                requiredWater = 200;
                requiredMilk = 100;
                requiredBeans = 12;
                payAmount = 6;
                break;
            default:
                return;
        }

        if (!checkStoredResource(requiredWater, requiredMilk, requiredBeans)) {
            outputCheckMessage(requiredWater, requiredMilk, requiredBeans);
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        updateStoredResource(-requiredWater, -requiredMilk, -requiredBeans, -1, payAmount);
    }

    public static boolean checkStoredResource(int requiredWater, int requiredMilk, int requiredBeans) {
        return storedWater >= requiredWater && storedBeans >= requiredMilk && storedBeans >= requiredBeans;
    }

    public static void outputCheckMessage(int requiredWater, int requiredMilk, int requiredBeans) {
        if (storedWater <= requiredWater) {
            System.out.println("Sorry, not enough water!");
        } else if (storedMilk <= requiredMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (storedBeans <= requiredBeans) {
            System.out.println("Sorry, not enough beans!");
        }
    }

    public static void updateStoredResource(int water, int milk, int beans, int cups, int money) {
        storedWater += water;
        storedMilk += milk;
        storedBeans += beans;
        storedCups += cups;
        storedMoney += money;
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

        updateStoredResource(addWater, addMilk, addBeans, addCups, 0);
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + storedMoney);
        storedMoney = 0;
    }

    public static void outputEmptyLine() {
        System.out.println("");
    }

}
