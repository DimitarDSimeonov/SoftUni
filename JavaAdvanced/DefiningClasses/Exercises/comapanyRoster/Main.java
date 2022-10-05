package definingClassesExercise.comapanyRoster;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = Integer.parseInt(scanner.nextLine());

        List< Department> departments = new ArrayList<>();

        for (int i = 0; i < line; i++) {
            String[] info = scanner.nextLine().split("\\s+");

            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String employeeDepartment = info[3];
            Employee employee = null;

            switch (info.length){
                case 4:
                    employee = new Employee(name,salary, position,employeeDepartment);
                    break;
                case 5:
                    if(info[4].contains("@")){
                        String email = info[4];
                        employee = new Employee(name,salary, position,employeeDepartment, email);
                    }else{
                        int age = Integer.parseInt(info[4]);
                        employee = new Employee(name,salary, position,employeeDepartment, age);
                    }
                    break;
                case 6:
                    String email = info[4];
                    int age = Integer.parseInt(info[5]);
                    employee = new Employee(name,salary, position,employeeDepartment, email, age);
                    break;
            }

            boolean departmentExist = departments.stream().anyMatch(dep -> dep.getName().equals(employeeDepartment));

            if(!departmentExist){
                Department department = new Department(employeeDepartment,new ArrayList<>());
                departments.add(department);
            }

            Department currentDepartment = departments.stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment))
                    .findFirst()
                    .get();

            currentDepartment.getEmployees().add(employee);
        }

        Department departmentWhitBiggestAverageSalary = departments.stream()
                .max(Comparator.comparingDouble(Department::calculateAverageSalary)).get();

        System.out.printf("Highest Average Salary: %s%n",departmentWhitBiggestAverageSalary.getName());

        departmentWhitBiggestAverageSalary.getEmployees()
                .stream().sorted((f,s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
