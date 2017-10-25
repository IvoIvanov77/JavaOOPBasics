package defining_classes.exercise.company_roster;

import java.util.*;

public class Department {

    private String name;
    private List<Employee> employeeList;

    Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    double getAverageSalary(){
        OptionalDouble average= this.employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        if(average.isPresent()){
            return average.getAsDouble();
        }
        return 0;
    }

    void printEmployees(){
        this.employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }


    @Override
    public String toString() {
        return this.name;
    }
}
