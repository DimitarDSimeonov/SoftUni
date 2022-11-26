package examPreparation.onlineShop.models.products.components;

import examPreparation.onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component {

    private int generation;

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return this.generation;
    }

    @Override
    public String toString() {
        return String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d) Generation: %d"
                ,getOverallPerformance(), getPrice(), getClass().getSimpleName(), getManufacturer(), getModel(), getId(), getGeneration());
    }
}
