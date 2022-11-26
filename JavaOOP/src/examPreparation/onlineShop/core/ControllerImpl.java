package examPreparation.onlineShop.core;

import examPreparation.onlineShop.common.constants.ExceptionMessages;
import examPreparation.onlineShop.common.constants.OutputMessages;
import examPreparation.onlineShop.core.interfaces.Controller;
import examPreparation.onlineShop.models.products.components.*;
import examPreparation.onlineShop.models.products.peripherals.*;
import examPreparation.onlineShop.core.interfaces.Controller;
import examPreparation.onlineShop.models.products.Product;
import examPreparation.onlineShop.models.products.components.*;
import examPreparation.onlineShop.models.products.computers.Computer;
import examPreparation.onlineShop.models.products.computers.DesktopComputer;
import examPreparation.onlineShop.models.products.computers.Laptop;
import examPreparation.onlineShop.models.products.peripherals.*;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl(){
        computers = new HashMap<>();
        components = new HashMap<>();
        peripherals = new HashMap<>();
    }
    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }
        computers.put(id, computer);
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        if (peripherals.containsKey(id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }
        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        peripherals.put(id, peripheral);
        computers.get(computerId).addPeripheral(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL,peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.get(computerId);
        Peripheral peripheral = computer.removePeripheral(peripheralType);
        components.remove(peripheral.getId());
        return String.format(OutputMessages.REMOVED_COMPONENT, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        if (components.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }
        components.put(id, component);
        computers.get(computerId).addComponent(component);
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.get(computerId);
        Component component = computer.removeComponent(componentType);
        components.remove(component.getId());
        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, computerId);
    }

    @Override
    public String buyComputer(int id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> computerList = computers.values().stream().filter(c -> c.getPrice() <= budget).collect(Collectors.toList());
        if (computerList.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,budget));
        }
        Collections.sort(computerList, Comparator.comparingDouble(Product::getOverallPerformance).reversed());
        return computerList.get(0).toString();
    }

    @Override
    public String getComputerData(int id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        return computers.get(id).toString();
    }
}
