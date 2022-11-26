package examPreparation.onlineShop.models.products.computers;

import examPreparation.onlineShop.models.products.BaseProduct;
import examPreparation.onlineShop.models.products.components.Component;
import examPreparation.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer{

    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super .getOverallPerformance();
        }
        double componentsPerformance = components.stream().mapToDouble(c -> c.getOverallPerformance()).average().getAsDouble();
        return super.getOverallPerformance() + componentsPerformance;
    }

    @Override
    public double getPrice() {
        double priceOfComponents = components.stream().mapToDouble(c -> c.getPrice()).sum();
        double priceOfPeripherals = peripherals.stream().mapToDouble(p -> p.getPrice()).sum();
        double totalPrice = super.getPrice() + priceOfComponents + priceOfPeripherals;
        return totalPrice;
    }

    @Override
    public void addComponent(Component component) {
        if (components.contains(component)) {
            String msg = String.format("Component %s already exists in %s with Id %d."
            ,component.getClass().getSimpleName(), this.getClass().getSimpleName() , getId());
            throw new IllegalArgumentException(msg);
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        boolean notExist = components.stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).findAny().isEmpty();
        if (components.isEmpty() || notExist) {
            String msg = String.format("Component %s does not exist in %s with Id %d."
            ,componentType, this.getClass().getSimpleName(), getId());
            throw new IllegalArgumentException(msg);
        }
        Component component = components.stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).findAny().get();
        components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.contains(peripheral)) {
            String msg = String.format("Peripheral %s already exists in %s with Id %d."
            ,peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), getId());
            throw new IllegalArgumentException(msg);
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        boolean notExist = peripherals.stream().filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findAny().isEmpty();
        if (peripherals.isEmpty() || notExist) {
            String msg = String.format("Peripheral %s does not exist in %s with Id %d."
            ,peripheralType, this.getClass().getSimpleName(), getId());
            throw new IllegalArgumentException(msg);
        }
        Peripheral peripheral = peripherals.stream().filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findAny().get();
        peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)"
        ,getOverallPerformance(), getPrice(), this.getClass().getSimpleName(), getManufacturer(), getModel(), getId()))
                .append(System.lineSeparator());

        sb.append(String.format(" Components (%d):", components.size())).append(System.lineSeparator());

        if (!components.isEmpty()) {
            for (Component component : components) {
                sb.append(component.toString())
                        .append(System.lineSeparator());
            }
        }

        double average = 0;
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",peripherals.size(), average))
                .append(System.lineSeparator());

        if (!peripherals.isEmpty()) {
            average = peripherals.stream().mapToDouble(e -> e.getOverallPerformance()).average().getAsDouble();

            for (Peripheral peripheral : peripherals) {
                sb.append(peripheral.toString())
                        .append(System.lineSeparator());
            }
        }


        return sb.toString().trim();
    }
}
