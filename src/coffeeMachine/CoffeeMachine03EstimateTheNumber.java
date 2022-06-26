package coffeeMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;  // Import the Scanner class

public class CoffeeMachine03EstimateTheNumber {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        Map<String, Integer> coffeResource = new HashMap<>();
        coffeResource.put("water", 200);
        coffeResource.put("milk", 50);
        coffeResource.put("beans", 15);

        System.out.println("Write how many ml of water the coffee machine has:");
        int inputWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int inputMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int inputBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int inputCups = scanner.nextInt();

        int ableCups = 0;
        int i = 0;
        while (true) {
            if (coffeResource.get("water") * i > inputWater ||
                    coffeResource.get("milk") * i > inputMilk ||
                    coffeResource.get("beans") * i > inputBeans) {
                ableCups = --i;
                break;
            }
            i++;
        }
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
