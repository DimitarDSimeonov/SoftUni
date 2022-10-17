package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add (Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
    public boolean remove (String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        Employee e = employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        return e;
    }
    public Employee getEmployee(String name) {
        Employee employee = employees.stream().filter(e -> e.getName().equals(name)).findFirst().get();
        return employee;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n",this.name));
        for(Employee e : employees) {
            sb.append(e.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
