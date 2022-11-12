package inheritanceExercise.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    public final static double COFFEE_MILLILITRES = 50;
    public final static BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITRES);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
