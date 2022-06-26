package machine;

public enum CoffeeRequiredResource {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    final int water;
    final int milk;
    final int bean;
    final int money;

    CoffeeRequiredResource(int water, int milk, int bean, int money) {
        this.water = water;
        this.milk = milk;
        this.bean = bean;
        this.money = money;
    }
}
