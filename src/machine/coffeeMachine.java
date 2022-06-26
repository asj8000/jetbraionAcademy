package machine;

import java.util.Objects;
import java.util.Scanner;

public class coffeeMachine {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    enum actionStatusCase {
        SELECT_ACTION, BUY_COFFEE, FILL_RESOURCE, TAKE_MONEY, CHECK_REMAINING_RESOURCE, EXIT
    }

    public static void main(String[] args) {
        boolean machinePowerStatus = true;
        coffeeMaker coffeeMaker = new coffeeMaker();
        actionStatusCase nextAction = actionStatusCase.SELECT_ACTION;
        while (machinePowerStatus) {
            switch (nextAction) {
                case SELECT_ACTION:
                    nextAction = getNextActionByUserInput();
                    break;
                case BUY_COFFEE:
                    coffeeMaker.makeCoffee();
                    nextAction = actionStatusCase.SELECT_ACTION;
                    break;
                case FILL_RESOURCE:
                    fillResource();
                    nextAction = actionStatusCase.SELECT_ACTION;
                    break;
                case TAKE_MONEY:
                    storedResourceManagement.takeMoney();
                    nextAction = actionStatusCase.SELECT_ACTION;
                    break;
                case CHECK_REMAINING_RESOURCE:
                    storedResourceManagement.printStorageStatus();
                    nextAction = actionStatusCase.SELECT_ACTION;
                    break;
                case EXIT:
                    machinePowerStatus = false;
                    break;
                default:
                    break;
            }
            outputEmptyLine();
        }
    }

    public static actionStatusCase getNextActionByUserInput() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String userAction = scanner.nextLine();
        switch (userAction) {
            case "buy":
                return actionStatusCase.BUY_COFFEE;
            case "fill":
                return actionStatusCase.FILL_RESOURCE;
            case "take":
                return actionStatusCase.TAKE_MONEY;
            case "remaining":
                return actionStatusCase.CHECK_REMAINING_RESOURCE;
            case "exit":
                return actionStatusCase.EXIT;
            default:
                return actionStatusCase.SELECT_ACTION;
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
        String emptyValue = scanner.nextLine();
        storedResourceManagement.updateStoredResource(addWater, addMilk, addBeans, addCups, 0);
    }

    public static void outputEmptyLine() {
        System.out.println(" ");
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

