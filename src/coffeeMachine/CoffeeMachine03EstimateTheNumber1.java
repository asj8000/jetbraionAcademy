package coffeeMachine;

import java.util.Scanner;  // Import the Scanner class

public class CoffeeMachine03EstimateTheNumber1 {

    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    final static int requiredWater = 200;
    final static int requiredMilk = 50;
    final static int requiredBeans = 15;

    static int inputWater = 0;
    static int inputMilk = 0;
    static int inputBeans = 0;
    static int inputCups = 0;

    public static void main(String[] args) {
        getInputValue();
        int ableCups = getAbleCups();
        outputMessage(ableCups);
    }

    public static void getInputValue() {
        System.out.println("Write how many ml of water the coffee machine has:");
        inputWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        inputMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        inputBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        inputCups = scanner.nextInt();
    }

    public static int getAbleCups() {
        int i = 0;
        while (requiredWater * i <= inputWater &&
                requiredMilk * i <= inputMilk &&
                requiredBeans * i <= inputBeans) {
            i++;
        }
        return --i;
    }

    public static void outputMessage(int ableCups) {
        if (ableCups >= inputCups) {
            System.out.print("Yes, I can make that amount of coffee");
            if (ableCups > inputCups) {
                int additionalCups = ableCups - inputCups;
                System.out.print(" (and even " + additionalCups + " more than that)");
            }
        } else {
            System.out.print("No, I can make only " + ableCups + "cup(s) of coffee");
        }
    }

}

